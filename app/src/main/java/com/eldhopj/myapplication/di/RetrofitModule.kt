package com.eldhopj.myapplication.di

import android.content.Context
import com.eldhopj.myapplication.BuildConfig
import com.eldhopj.myapplication.R
import com.eldhopj.android_extensions.getAppUserAgent
import com.eldhopj.android_extensions.isOnline
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val HEADER_CACHE_CONTROL =
        "Cache-Control" // removes Cache-Control header from the server, and apply our own cache control
    private const val HEADER_PRAGMA = "Pragma" // overrides "Not to use caching scenario"
    private const val CACHE_SIZE = 5 * 1024 * 1024.toLong() // 5 MB
    private const val MAX_AGE = 10 // if a request comes within 10s it will show from cache
    private const val MAX_STALE = 15 // No days cache works when offline mode

    @Provides
    @Singleton
    fun providesOkHttpClient(
        cache: Cache,
        @Named("networkInterceptor") networkInterceptor: Interceptor,
        @Named("offlineInterceptor") offlineInterceptor: Interceptor,
        @Named("header") headers: Interceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.apply {
            cache(cache)
            addInterceptor(offlineInterceptor)
            addNetworkInterceptor(networkInterceptor) // only used when network is on
            addInterceptor(headers)
            build()
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(logging)
            }
            return build()
        }
    }

    @Provides
    @Singleton
    fun providesCache(@ApplicationContext context: Context): Cache {
        return Cache(File(context.cacheDir, context.getString(R.string.app_name)), CACHE_SIZE)
    }

    @Provides
    @Singleton
    @Named("header")
    fun providesHeaders(@ApplicationContext context: Context): Interceptor {
        /**If there are any headers its adds in here */
        return Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                //Ignoring endpoints which need not needed tokens
//                .apply {
//                    if (!original.url.encodedPath.equals(
//                            "/oauth/token",
//                            ignoreCase = true
//                        ) && !original.url.encodedPath.equals(
//                            "/api/v1/login",
//                            ignoreCase = true
//                        ) && !original.method.equals("post", ignoreCase = true)
//                    ) {
//                        header("Authorization", "key")
//                    }
//                }
                .header("User-Agent", context.getAppUserAgent()) // Headers
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    /**
     * This interceptor will be called ONLY if the network is available
     */
    @Provides
    @Singleton
    @Named("networkInterceptor")
    fun providesNetworkInterceptor(): Interceptor {
        return Interceptor { chain ->
            val response = chain.proceed(chain.request())
            val cacheControl = CacheControl.Builder()
                .maxAge(
                    MAX_AGE,
                    TimeUnit.SECONDS
                ) // Cache the response only for 10 sec, so if a request comes within 10sec it will show from cache
                .build()
            response.newBuilder()
                .removeHeader(HEADER_PRAGMA)
                .removeHeader(HEADER_CACHE_CONTROL) // removes cache control from the server
                .header(HEADER_CACHE_CONTROL, cacheControl.toString()) // applying our cache control
                .build()
        }
    }

    /**
     * This interceptor will be called both if the network is available and the network is not available
     */
    @Provides
    @Singleton
    @Named("offlineInterceptor")
    fun providesOfflineInterceptor(@ApplicationContext context: Context): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()
            if (!context.isOnline()) {
                val cacheControl = CacheControl.Builder()
                    .maxStale(MAX_STALE, TimeUnit.DAYS)
                    .build()
                request = request.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .cacheControl(cacheControl)
                    .build()
            }
            chain.proceed(request)
        }
    }
}

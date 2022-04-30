package com.eldhopj.myapplication.data.remote.handler

import com.eldhopj.myapplication.data.remote.service.ApiService
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Retrofit

/**
 * Api handler
 *
 * @constructor
 *
 * @param retrofit
 */
@Singleton
class ApiHandler @Inject constructor(retrofit: Retrofit) {

    private val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }

    // TODO :  Rename class with api path
    // Eg: /content/songs -> ContentApiHandler
}

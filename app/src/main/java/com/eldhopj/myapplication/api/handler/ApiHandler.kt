package com.eldhopj.myapplication.api.handler

import com.eldhopj.myapplication.api.service.ApiService
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

    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    // TODO :  Rename class with api path
    // Eg: /content/songs -> ContentHandler
}

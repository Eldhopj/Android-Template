package com.eldhopj.myapplication.ui.repositories

import com.eldhopj.myapplication.api.handler.ApiHandler
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Api repo
 *
 * @property apiHandler
 * @constructor Create empty Api repo
 */
@Singleton
class ApiRepo @Inject constructor(private val apiHandler: ApiHandler) {

    // TODO :  Rename class with api path
    // Eg: /content/songs -> ContentRepo
}

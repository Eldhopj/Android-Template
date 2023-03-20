package com.eldhopj.myapplication.data.remote

import com.eldhopj.myapplication.utils.constants.StringConstants

/**
 * Network response
 *
 * @param T
 * @constructor Create empty Network response
 * @author eldhopj
 */
sealed class Output<out T> {

    data class Loading(val isLoading: Boolean) : Output<Nothing>()

    data class Success<out T>(val data: T?) : Output<T>()

    data class Error(val errorData: ErrorData) : Output<Nothing>()

    data class Exception(val throwable: Throwable) : Output<Nothing>()
}

class ErrorData(val code: Int, val errorMessage: String? = StringConstants.UNKNOWN_ERROR)

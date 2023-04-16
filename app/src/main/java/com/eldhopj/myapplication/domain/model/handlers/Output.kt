package com.eldhopj.myapplication.domain.model.handlers

/**
 * Network response
 *
 * @param T
 * @constructor Create empty Network response
 * @author eldhopj
 */
sealed interface Output<out T> {

    data class Loading(val isLoading: Boolean) : Output<Nothing>

    data class Success<out T>(val data: T?) : Output<T>

    data class Error(val errorData: ErrorData) : Output<Nothing>

    data class Exception(val throwable: Throwable) : Output<Nothing>
}

package com.eldhopj.myapplication.data.remote

/**
 * Network response
 *
 * @param T
 * @constructor Create empty Network response
 */
sealed class NetworkResponse<out T> {

    /**
     * Loading
     *
     * @constructor Create empty Loading
     */
    object Loading : NetworkResponse<Nothing>()

    /**
     * Success
     *
     * @param T
     * @property data
     * @constructor Create empty Success
     */
    data class Success<out T>(val data: T?) : NetworkResponse<T>()

    /**
     * Error
     *
     * @param T
     * @property message
     * @constructor Create empty Error
     */
    data class Error<out T>(val message: String) : NetworkResponse<T>()
}

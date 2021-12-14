package com.eldhopj.myapplication.utils.network

/**
 * Resource
 *
 * @param T
 * @property data
 * @property message
 * @constructor Create empty Resource
 */
sealed class NetworkResponse<T>(val data: T? = null, val message: String? = null) {
    /**
     * Loading
     *
     * @param T
     * @constructor
     *
     * @param data
     */
    class Loading<T>(data: T? = null) : NetworkResponse<T>(data)

    /**
     * Success
     *
     * @param T
     * @constructor
     *
     * @param data
     */
    class Success<T>(data: T?) : NetworkResponse<T>(data)

    /**
     * Error
     *
     * @param T
     * @constructor
     *
     * @param message
     * @param data
     */
    class Error<T>(message: String, data: T? = null) : NetworkResponse<T>(data, message)
}

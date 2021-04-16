package com.eldhopj.myapplication.utils.network

/**
 * Resource
 *
 * @param T
 * @property status Request status [Status]
 * @property data Response data
 * @property message Error message
 * @constructor Create empty Resource
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        /**
         * Success
         *
         * */
        fun <T> success(data: T?) = Resource(Status.SUCCESS, data, null)

        /**
         * Error
         *
         * */
        fun <T> error(message: String, data: T?) = Resource(Status.ERROR, data, message)

        /**
         * Loading
         *
         * */
        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)
    }
}

/**
 * Request Status
 * */
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

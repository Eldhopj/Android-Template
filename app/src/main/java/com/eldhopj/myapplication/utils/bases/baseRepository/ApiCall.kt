package com.eldhopj.myapplication.utils.bases.baseRepository

import com.eldhopj.myapplication.data.remote.Output
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


/**
 * Api call
 *
 * @constructor Create empty Api call
 */
interface ApiCall {
    /**
     * Safe api call
     *
     * @param T Response data type
     * @param dispatcher CoroutineDispatcher
     * @param apiCall api Call
     * @receiver
     * @return
     */
    fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> Response<T>
    ): Flow<Output<T>>
}

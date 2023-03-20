package com.eldhopj.myapplication.utils.bases.baseRepository

import com.eldhopj.myapplication.data.remote.Output
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

/**
 * Db call
 *
 * @constructor Create empty Db call
 */
interface DbCall {
    /**
     * Safe db call
     *
     * @param T  data type
     * @param dispatcher CoroutineDispatcher
     * @param dbCall roomDb call
     * @receiver
     * @return
     */
    fun <T> safeDBCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        dbCall: suspend () -> T
    ): Flow<Output<T>>
}

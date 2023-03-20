package com.eldhopj.myapplication.utils.bases.baseRepository

import com.eldhopj.myapplication.data.remote.Output
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SafeDbCall : DbCall {
    override fun <T> safeDBCall(
        dispatcher: CoroutineDispatcher,
        dbCall: suspend () -> T
    ): Flow<Output<T>> = flow {
        emit(Output.Loading(true))
        emit(Output.Success(dbCall.invoke()))
        emit(Output.Loading(false))
    }.catch { e ->
        emit(Output.Loading(false))
        emit(Output.Exception(e))
    }.flowOn(dispatcher)
}

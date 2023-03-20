package com.eldhopj.myapplication.utils.bases

import android.util.MalformedJsonException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eldhopj.myapplication.data.remote.ErrorData
import java.io.InterruptedIOException
import java.net.SocketException
import java.net.UnknownHostException
import logcat.logcat

abstract class BaseViewModel : ViewModel() {

    private val _errorMessage = MutableLiveData<ErrorData>()
    val errorMessage: LiveData<ErrorData> = _errorMessage

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun setLoading(loadingStatus: Boolean) {
        _loading.value = loadingStatus
    }

    protected fun handleException(
        throwable: Throwable,
        tag: String = "",
        apiServiceKey: String = "",
        request: Any? = null
    ) {
        _loading.value = false
        val reqStr = request?.toString() ?: ""
        val errorCode = when (throwable) {
            is InterruptedIOException -> {
                800
            }
            is UnknownHostException -> { // no connectivity
                800
            }
            is SocketException -> {
                800
            }
            is MalformedJsonException -> {
                803
            }
            else -> {
                999
            }
        }
        _errorMessage.value = ErrorData(errorCode, throwable.localizedMessage)
        logcat("API_Exception") { reqStr }
    }

    protected fun handleError(
        errorData: ErrorData,
        tag: String = "",
        request: Any? = null
    ) {
        _errorMessage.value = errorData
    }
}

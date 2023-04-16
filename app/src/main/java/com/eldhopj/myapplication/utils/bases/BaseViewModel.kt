package com.eldhopj.myapplication.utils.bases

import android.util.MalformedJsonException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eldhopj.myapplication.domain.model.handlers.ErrorData
import java.io.InterruptedIOException
import java.net.SocketException
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel() {

    private val _errorMessage = MutableLiveData<ErrorData>()
    val errorMessage: LiveData<ErrorData> = _errorMessage

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun setLoading(loadingStatus: Boolean) {
        _loading.value = loadingStatus
    }

    protected fun handleException(
        throwable: Throwable
    ) {
        _loading.value = false
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
    }

    protected fun handleError(
        errorData: ErrorData
    ) {
        _errorMessage.value = errorData
    }
}

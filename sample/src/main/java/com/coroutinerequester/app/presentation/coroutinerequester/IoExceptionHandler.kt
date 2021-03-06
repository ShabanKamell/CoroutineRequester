package com.coroutinerequester.app.presentation.coroutinerequester

import com.coroutinerequester.app.R
import com.sha.coroutinerequester.exception.handler.throwable.ThrowableHandler
import com.sha.coroutinerequester.exception.handler.throwable.ThrowableInfo
import okhttp3.internal.http2.ConnectionShutdownException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class IoExceptionHandler : ThrowableHandler<IOException>() {

    override fun supportedErrors(): List<Class<out IOException>> {
        return listOf(IOException::class.java, SocketTimeoutException::class.java)
    }

    override fun handle(info: ThrowableInfo) {

        if (info.throwable is SocketTimeoutException) {
            info.presentable.showError(R.string.socket_timeout_exception)
            return
        }

        if (info.throwable is UnknownHostException) {
            info.presentable.showError(R.string.offline_internet)
            return
        }

        if (info.throwable is ConnectionShutdownException) {
            info.presentable.showError(R.string.socket_timeout_exception)
            return
        }

        info.presentable.showError(R.string.offline_internet)
    }
}

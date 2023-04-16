package com.bennyhuo.kotlin.coroutines.dispatcher.ui


import com.bennyhuo.kotlin.coroutines.dispatcher.Dispatcher
import os.Handler
import os.Looper


object AndroidDispatcher: Dispatcher {
    private val handler = Handler(Looper.getMainLooper())

    override fun dispatch(block: () -> Unit) {
        handler.post(block)
    }
}
package com.bennyhuo.kotlin.coroutines.dispatcher

import com.bennyhuo.kotlin.coroutines.dispatcher.ui.AndroidDispatcher
import com.bennyhuo.kotlin.coroutines.dispatcher.ui.SwingDispatcher

/**
 * 自定义Dispatchers
 * @author ahl
 */
object CustomDispatchers {

    val Android by lazy {
        DispatcherContext(AndroidDispatcher)
    }

    val Swing by lazy {
        DispatcherContext(SwingDispatcher)
    }

    val Default by lazy {
        DispatcherContext(DefaultDispatcher)
    }
}
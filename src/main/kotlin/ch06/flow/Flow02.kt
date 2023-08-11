package ch06.flow

import com.bennyhuo.kotlin.coroutines.dispatcher.CustomDispatchers
import com.bennyhuo.kotlin.coroutines.dispatcher.ui.AndroidDispatcher
import com.sun.org.apache.xpath.internal.operations.And
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import os.Looper
import utils.log

 suspend  fun main() {
   Looper.prepareMainLooper()
    val job =  GlobalScope.launch(CustomDispatchers.Android) {
         (1..5).asFlow().collect {
             log(it)
         }
         (6..15).asFlow().collect {
             log(it)
         }
     }
     Looper.loop()


}
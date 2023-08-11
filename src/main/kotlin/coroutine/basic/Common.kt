package coroutine.basic

import common.api.User

fun showUser(user: User){
    println(user)
}

fun showError(t:Throwable){
    t.printStackTrace(System.out)
}
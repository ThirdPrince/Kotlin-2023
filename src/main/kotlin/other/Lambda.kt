package other

import block.test1

/**
 * 高阶函数 lambda 的样例
 */
fun main() {
    val result = test(1,2){
        n1,n2 -> n1+n2
    }
    println("result =$result")

    val list = mutableListOf(1,2,3,45,6,7,8)
    list.also {
        it.add(0,0)
    }
    list.forEach(::println)
}
val sum = { arg1:Int,arg2:Int ->
    arg1 + arg2
}

fun test(arg1:Int,arg2:Int,block:(Int,Int)->Int):Int{
 return block(arg1,arg2)
}
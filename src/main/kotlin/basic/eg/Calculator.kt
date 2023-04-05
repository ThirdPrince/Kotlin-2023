package basic.eg

/**
 * @author dhl
 * 计算器
 * 函数引用，集合，字符串模版
 */
fun main(vararg args:String) {

//    val fun1 = ::plus
//    println(fun1(1, 2))
    if(args.size < 3){
        return showHelp()
    }

    val operators = mapOf(
        "+" to ::plus,
        "-" to ::plus,
        "*" to :: times,
        "/" to ::div

    )


    val op = args[1]
    val opFunc = operators[op]?: return showHelp()

    try {
        println("Input: ${args.joinToString(" ")}")
        println("Output: ${opFunc(args[0].toInt(), args[2].toInt())}")
    }catch (e:Exception){
        println("Invalid Arguments")
        showHelp()
    }


}


fun plus(arg0:Int,arg1:Int):Int{
    return arg0 + arg1
}

fun minus(arg0: Int,arg1: Int):Int{
    return arg0 - arg1
}

fun times(arg0: Int,arg1: Int):Int{
    return arg0 * arg1
}

fun div(arg0: Int,arg1:Int):Int{
    return arg0 / arg1
}
fun showHelp(){
    println("""
        Simple Calculator:
        Input: 3 * 4
        Output:12
    """.trimIndent())
}
package types.extensions

/**
 * 扩展方法
 * 本质是静态方法
 * @author dhl
 */
fun main() {

    println("Hello".padding(10))
    println("Hello".times(3))
}

fun String.padding(count:Int,char: Char = ' '):String{
    val padding = (1..count).joinToString(""){
        char.toString()
    }
    return  "${padding}${this}${padding}"
}
fun String.times(count:Int):String{
    return (1..count).joinToString(""){
        this
    }
}
/**
 * 第二种写法
 */
// fun String.times(time: Int): String {
//    val stringBuilder = StringBuilder()
//    for (i in 0 until time) stringBuilder.append(this)
//    return stringBuilder.toString()
//}
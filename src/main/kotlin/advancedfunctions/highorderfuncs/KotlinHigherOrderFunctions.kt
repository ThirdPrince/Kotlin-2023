package advancedfunctions.highorderfuncs

/**
 * 扩展方法
 * 本质是静态方法
 * @author dhl
 */
fun main() {

    println("Hello".padding(10))
    println("Hello".times(3))
    forEachDemo()
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
/**
 * forEach 接收类型是（T）->Unit
 * println 是符合 (T) -> Unit的类型
 */
fun forEachDemo(){
    val list = listOf(1,2,3,4,5,6,7)
    val lambda = {arg:Int -> println(arg)}
    list.forEach(lambda)
    list.forEach {
        println(it)
    }
    list.forEach(::println)


    val lambda2 = {index:Int,value:Int -> println("index = $index,value=$value")}
    list.forEachIndexed(lambda2)
    list.forEachIndexed{
        index, i ->
        println("index = $index,value=$i")
    }

}
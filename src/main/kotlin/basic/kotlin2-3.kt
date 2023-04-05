package basic

/**
 *  kotlin basic 2-3
 */
fun main() {
    runBlock {
        List(1000){
            println("hello world")
        }
    }

}

/**
 * 记录函数运行的时间
 */
fun runBlock(block:()->Unit){
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() -start)
}
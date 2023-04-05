package basic.array

/**
 * Array
 */
fun main() {
    val a = IntArray(5)
    println(a.size)

    val b = ArrayList<String>()
    println(b.size)

    val c0 = intArrayOf(1,2,3,4,5,6)
    val c1 = IntArray(5){
        3 *(it+1)
    }
    println(c0.contentToString())
    println(c1.contentToString())

    val d = arrayOf("hello","world")

    d[1] = "kotlin"
    println("${d[0]},${d[1]}")

    val e = floatArrayOf(1f,3f,5f,7f)
    for (element in e){
        println(element)
    }
    e.forEach {
        println(it)
    }


}
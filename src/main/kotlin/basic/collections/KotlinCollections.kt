package basic.collections

/**
 * 集合
 * Kotlin 集合 和Java 一样
 */
fun main() {

    val intList:List<Int> = listOf(1,2,3,4)
    val intList2:MutableList<Int> = mutableListOf()

    val map :Map<String,Any> = mapOf("name" to "benny","age" to 20)
    val map2:Map<String,Any> = mutableMapOf("name" to "benny","age" to 20)

    val stringList = ArrayList<String>()

    for(i in 0..10){
        stringList.add("num:$i")
    }
    for(i in 0..10){
        stringList+="num:$i"
    }
    stringList[5] = "HelloWorld"
    val valueAt5 = stringList[5]

    val hashMap = HashMap<String,Int>()
    hashMap["hello"] = 10
    println(hashMap["hello"])

    val pair = "hello" to "Kotlin"
    val first = pair.first
    val second = pair.second
    println("first = $first")
    println("first = $second")

    val triple = Triple("x",2,3.0)
    val first1 = triple.first
    val second2 = triple.second
    val third3 = triple.third
    val(x,y,z) = triple




}
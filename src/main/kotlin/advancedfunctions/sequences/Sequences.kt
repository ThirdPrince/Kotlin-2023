package advancedfunctions.sequences

/**
 * Sequences
 * @author dhl
 */
fun main() {
    testFilter()
}

private fun  testFilter(){
    val list = listOf(1,2,3,4)
    println(list)
    val listFilter = list.filter {
       it % 2== 0
    }
    println(listFilter)
}


/**
 * 测试Map
 */
private fun  testMap(){
    val list = listOf(1,2,3,4)
    println(list)
    val listMap = list.map {
        it *2 +1
    }
    println(listMap)
}

private fun  testFlatMap(){
    val list = listOf(1,2,3,4)
    println(list)

}
package basic.range

/**
 * Range
 * 区间
 */
fun main() {
    val intRange = 1..10 // [1,10]
    val charRange = 'a'..'z'
    val longRange = 1L..100L

    val floatRange = 1f .. 2f
    val doubleRange = 1.0 .. 2.0
    println(floatRange.toString())


    val intRangeWithStep = 1..10 step 2
    val charRangeWithStep = 'a'..'z' step 2



    val intRangeExclusive = 1 until 10 // [1,10)
    val charRangeExclusive = 'a' until 'z'
    val longRangeExclusive = 1L until 100L

    println(intRangeWithStep.joinToString())

    for(element in intRange){
        println(element)
    }



    intRange.forEach {
        println(it)
    }

    if(3.0 !in floatRange){
        println("3 in range 'intRange'")
    }

    if(12 in intRange){
        println("12 not in range ")
    }
    val array = intArrayOf(1,3,5,7)

    for (element in array){
        println(element)
    }
    for (i in array.indices){
        println(i)
    }

    for(i in 0 until  5){
        println(i)
    }
}
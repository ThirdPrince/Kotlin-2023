package basic.range

/**
 * Range
 * 区间
 */
fun main() {
    val intRange = 1..10 // [1,10]
    val charRange = 'a'..'z'
    val longRange = 1L..100L

    val floatRange = 1f..2f
    val doubleRange = 1.0..2.0
    println(intRange.joinToString())


    val intRangeExclusive = 1 until 10 // [1,10)
    val charRangeExclusive = 'a' until 'z'
    val longRangeExclusive = 1L until 100L

    println(intRangeExclusive.joinToString())
}
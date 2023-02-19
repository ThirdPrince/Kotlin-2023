package block

fun main() {
    test0 {
        println("A")
    }
    println("-----")

    test1 {
        "无参有返回值"
    }

    println("-----")

    test2 { x, y ->
        x + y
    }

    test3 { x, y ->
        println("参数x =$x,参数y = $y")

    }

}

/**
 * 无参无返回值
 */
fun test0(block: () -> Unit) {
    block()
}

/**
 * 无参有返回值
 */
fun test1(block: () -> String) {
    val result = block()
    println(result)
}

fun test2(block: (x: Int, y: Int) -> Int) {
    val result = block(1, 2)
    println(result)
}

fun test3(block: (x: Int, y: Int) -> Unit) {
    block(1, 2)
}


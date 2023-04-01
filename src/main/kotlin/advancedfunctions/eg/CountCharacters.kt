package advancedfunctions.eg

import java.io.File

/**
 * 统计字符个数，去除空格
 * @author dhl
 */
fun main() {
    println(File("build.gradle.kts").readText())
    File("build.gradle.kts").readText()
        .toCharArray()
        .filterNot { it.isWhitespace() }
        .groupBy { it }
        .map {
            it.key to it.value.size
        }.let {
            println(it)
        }
}
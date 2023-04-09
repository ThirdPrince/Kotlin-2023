package basic.nullables
/**
 * null 安全
 */
fun main() {

    var noNull :String?= "hell0"
    println(noNull?.length)
    val person = Person()
    val title = person.title
    println(title.length)

}
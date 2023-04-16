package basic.types.classes

/**
 * 注意receiver
 * @author dhl
 */
class Person(age: Int, name: String) {
    var age: Int = age
        get() {
            return field
        }
        set(value) {
            println("setAge:$value")
        }
    var name: String = name
        get() {
            return field
        }
        set(value) {
            println("setName:$name")
        }
}

fun main() {
    val ageRef = Person::age
    val person = Person(18, "ThirdPrices")
    val nameRef = person::name
    ageRef.set(person, 20)
    nameRef.set("dhl")

}
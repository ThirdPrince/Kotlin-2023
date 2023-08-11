package basic.eg

data class User(
    val name: String,
    val age: Int
) {
    @JvmName("getName1")
    fun getName(): String {
        return name
    }

    @JvmName("getAge1")
    fun getAge(): Int {
        return age
    }
}
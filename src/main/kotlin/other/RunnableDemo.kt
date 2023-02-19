package other

fun main() {
    val runnable = Runnable{
        println("run")
    }
    val block:()->Unit = runnable::run
    runnable.run()
    block()
    block.invoke()



}
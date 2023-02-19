package ch03

/**
 * 模拟主函数挂起
 */
fun main() {
  runSuspend {
      suspendMain()
  }
}

suspend fun suspendMain(){
    println("A")
}
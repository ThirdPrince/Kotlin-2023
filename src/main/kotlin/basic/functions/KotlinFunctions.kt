package basic.functions

/**
 * 函数
 * 有receiver 的就是函数
 * Foo.(String,Long)->Any == (Foo,String,Long)->Any
 *
 */
fun main() {


    /**
     * (Foo,String,Long)-Any = Foo.(String,Long)->Any = Function3(Foo,String,Long,Any>
     */
    val f:()->Unit = ::foo
    val x:(Foo,String,Long) -> Any = Foo::bar
    val x0:Foo.(String,Long)->Any = Foo::bar

    val y:(Foo,String,Long)->Any = x
    val z:Function3<Foo,String,Long,Any> = x


    /**
     * f(r,x,y) = r*(x+y)
     * 令 r = 2
     * m(x,y) = f(2,x,y) = 2*(x+y)
     */
    val foo = Foo()
    val m:(String,Long) ->Any = foo::bar

    yy(x)
    multiParameters(1,23,4)
    println(multiReturnValues())


}
fun yy(p:(Foo,String,Long)->Any){
    println("----")
    p(Foo(), "Hello", 3L)
}
class Foo{
    fun bar(p0:String,p1:Long):Any{
        println("-----")
        return "222"
    }
}
fun foo(){

}
fun foo(p0:Int):String{
    return "11"
}

fun defaultParameter(x:Int = 5,y:String,z:Long = 0L){
    println("--")
}

fun multiParameters(vararg ints:Int){
    println(ints.contentToString())
}
fun multiReturnValues():Triple<Int,Long,Double>{
    return Triple(1,3L,4.0)
}
package basic.types.classes

/**
 * 加上open 关键字才能被继承
 */
open class SimpleClass(var x:Int, val y:String): AbsClass(), SimpleInf {

    override val simpleProperty: Int
        get() {
            return 2
        }


    override fun absMethod() {

    }

    override fun simpleMethod() {

    }
}
class SimpleClass2(x:Int,y:String): SimpleClass(x,y){
    override fun absMethod() {
        super.absMethod()
    }
}
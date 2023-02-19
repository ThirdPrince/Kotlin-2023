package ch01


import java.util.concurrent.CompletableFuture


fun bitmapCompletableFuture(url:String): CompletableFuture<Bitmap> = CompletableFuture.supplyAsync{
    download(url)
}

fun<T> List<CompletableFuture<T>>.allOf():CompletableFuture<List<T>>{

    return CompletableFuture.allOf(*this.toTypedArray()).thenApply { this.map { it.get() } }
}

fun callSimplifiedCompletableFuture(){
    urls.map {
        bitmapCompletableFuture(it)
    }.allOf().thenAccept{
        println(it.size)
    }.join()

}

fun main(){
    callSimplifiedCompletableFuture()
}
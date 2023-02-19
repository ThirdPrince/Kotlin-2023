package ch08

import java.io.EOFException
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

val SERVER_HOST = "localhost"
val SERVER_PORT = 10000

val CHARSET = Charsets.UTF_8

fun main() {
    val selector = Selector.open()
    val serverAddress = InetSocketAddress(SERVER_HOST, SERVER_PORT)
    ServerSocketChannel.open().use {
        it.bind(serverAddress)
        it.configureBlocking(false)
        it.register(selector,it.validOps(),null)
        println("Server started on $SERVER_HOST:$SERVER_PORT")
        while (true){
            selector.select()
            selector.selectedKeys().let { keys->
                keys.forEach { selectionKey ->
                    when{
                        selectionKey.isAcceptable->{
                            val clientChannel = it.accept()
                            clientChannel.configureBlocking(false)
                            clientChannel.register(selector,SelectionKey.OP_READ)
                            println("Accepted :${clientChannel.remoteAddress}")
                        }
                        selectionKey.isReadable->{
                            val clientChannel = selectionKey.channel() as SocketChannel
                            runCatching {
                                val buffer = ByteBuffer.allocate(256)
                                val length = clientChannel.read(buffer)
                                if(length ==-1){
                                    throw EOFException()
                                }else{
                                    buffer.flip()
                                    println("Received ：${CHARSET.decode(buffer.asReadOnlyBuffer())}")
                                }

                            }.onFailure {
                                clientChannel.close()
                                println("Client disconnected")
                            }
                        }
                    }
                }
                keys.clear()
            }

        }
    }


}
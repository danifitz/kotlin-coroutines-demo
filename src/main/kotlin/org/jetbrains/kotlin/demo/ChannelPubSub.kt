package org.jetbrains.kotlin.demo

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import javax.servlet.http.HttpServletResponse

class ChannelPubSub {
	
	fun example(res: HttpServletResponse) {
			val builder = StringBuilder()
			builder.append("result is: \n")
		
		GlobalScope.launch {
			val squares = produceSquares()
			
			squares.consumeEach{
				builder.append(it)
				builder.append("\n")
			}
			
		}
		res.writer.write(builder.toString())
		println("Done!")
		
	}
	
	fun CoroutineScope.produceSquares() : ReceiveChannel<Int> = produce {
		println("sending 5 numbers")
		for(x in 1..5) channel.send(x*x)
	}
	
	
}
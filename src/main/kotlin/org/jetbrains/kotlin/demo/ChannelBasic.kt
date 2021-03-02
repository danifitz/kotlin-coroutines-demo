package org.jetbrains.kotlin.demo

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import javax.servlet.http.HttpServletResponse

class ChannelBasic {
	
	fun example(res: HttpServletResponse) {
		val channel = Channel<Int>()
		
		GlobalScope.launch {
			
			process(channel)
		}
		
		GlobalScope.launch {
			val result = receive(channel)
			println("result = ${result}")
			res.writer.write(result)	
		}
		
	}
	
	suspend fun process(channel : Channel<Int>) {
		println("sending 5 numbers")
		for(x in 1..5) channel.send(x*x)
		println("sent 5 numbers")

	}
	
	suspend fun receive(channel : Channel<Int>) : String {
		println("receiving 5 numbers")
		val builder = StringBuilder()
		builder.append("result is: \n")
		repeat(5) {
			builder.append(channel.receive())
			builder.append("\n")
		}
		println("received 5 numbers")
		return builder.toString()
	}
}
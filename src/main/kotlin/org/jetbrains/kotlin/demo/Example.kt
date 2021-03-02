package org.jetbrains.kotlin.demo

import kotlinx.coroutines.*
import javax.servlet.http.HttpServletResponse

class Example {
    fun doSomething(res: HttpServletResponse) {
    	GlobalScope.launch {
    		val one = doSomethingUsefulOne()
    		val two = doSomethingUsefulTwo()
    		res.writer.write("in something: answer is ${one+two}")
    	}
    }
    
    suspend fun doSomethingUsefulOne() : Int {
		Thread.sleep(1000L)
      return 13
    }
    
    suspend fun doSomethingUsefulTwo() : Int {
		Thread.sleep(1000L)
      return 29
    }

}
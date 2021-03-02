package org.jetbrains.kotlin.demo

import kotlinx.coroutines.*
import javax.servlet.http.HttpServletResponse

class AsyncExample {
    fun doSomething(res: HttpServletResponse) {
    	GlobalScope.launch {
    		val one = async {doSomethingUsefulOne()}
    		val two = async{doSomethingUsefulTwo()}
    		res.writer.write("in something: answer is ${one.await()+two.await()}")
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
package org.jetbrains.kotlin.demo

import kotlinx.coroutines.*
import javax.servlet.http.HttpServletResponse

class TimeoutExample {
	
    fun doSomething(res: HttpServletResponse) {
		val handler = CoroutineExceptionHandler { _,exception ->
			res.writer.write("Operation timed out $exception")
		}
    	GlobalScope.launch(handler) {
    		val one = async {doSomethingUsefulOne()}
			val two = async {doSomethingUsefulTwo()}
			
    		res.writer.write("in something: One result: ${one.await()} ,answer is ${two.await()}")
    	}
    }
	
	suspend fun doSomethingUsefulOne() = runBlocking {
		val result = withTimeoutOrNull(1000L) {
			repeat(1000) {
				i ->
				println("I'm sleeping $i ....")
				delay(500L)
			}
			"performed 1000 iterations"
		}
		
		if(result == null) {
			"Operation Timed out"
		} else {
			"Result is $result"
		}
    }
    
    suspend fun doSomethingUsefulTwo() : Int {
		Thread.sleep(1000L)
      return 29
    }

}
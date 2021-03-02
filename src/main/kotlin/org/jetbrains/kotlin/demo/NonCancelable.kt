package org.jetbrains.kotlin.demo

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class NonCancelable {

	fun example() = runBlocking {
		val job = GlobalScope.launch(EmptyCoroutineContext,CoroutineStart.LAZY) {
			
			process()

		}

		delay(1300L)
		println("I'm tired of waiting")
		job.cancelAndJoin()
		println("Now I can quit")
	}


	suspend fun process() {
		try {
			repeat(10) {

				i ->
				println("job: I'm sleeping $i ...")
				delay(500L)
			}

		} finally {
			withContext(NonCancellable) {
				println("job: I'm running finally")
				delay(1000L);
				println("job: And I've just delayed 1 sec because I'm non-cancelable")
			}
		}
	}
}
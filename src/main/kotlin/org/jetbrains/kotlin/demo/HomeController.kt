package org.jetbrains.kotlin.demo

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlinx.coroutines.GlobalScope
import org.jetbrains.kotlin.demo.Example

import kotlin.system.*

@WebServlet(name = "Hello", value = ["/hello"])
class HomeController : HttpServlet() {
	
	var example = Example()

    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.write("Hello, World!\n")
        val path : String = req.getRequestURI()
        println("path called: ${path}")
       
	    example.doSomething(res)
		Thread.sleep(2000L)
    }
    
    
} 

@WebServlet(name = "PubSub", value = ["/testChannelPubSub"])
class PubSubController : HttpServlet() {
	
	var chanPubSub = ChannelPubSub()

    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.write("Hello, PubSub!\n")
        val path : String = req.getRequestURI()
        println("path called: ${path}")
        
       
        chanPubSub.example(res)
		Thread.sleep(2000L)
    }
    
    
} 

@WebServlet(name = "Async", value = ["/testAsync"])
class AsyncController : HttpServlet() {
	
	var asyncTest = AsyncExample()

    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.write("Hello, Async!\n")
        val path : String = req.getRequestURI()
        println("path called: ${path}")
        
       
        asyncTest.doSomething(res)
		Thread.sleep(2000L)
    }
    
    
} 

@WebServlet(name = "ChannelBasic", value = ["/testChannelBasic"])
class BasicController : HttpServlet() {
	
	var chanBasic = ChannelBasic()

    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.write("Hello, Basic!\n")
        val path : String = req.getRequestURI()
        println("path called: ${path}")
        
       
        chanBasic.example(res)
		Thread.sleep(2000L)
    }
    
    
} 

@WebServlet(name = "CancelTest", value = ["/testCancel"])
class CancelController : HttpServlet() {
	
	var nonCancel = NonCancelable()

    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.write("Hello, Cancel!\n")
        val path : String = req.getRequestURI()
        println("path called: ${path}")
        
       
        nonCancel.example()
		Thread.sleep(2000L)
    }
    
    
} 


@WebServlet(name = "TimeoutTest", value = ["/testTimeout"])
class TimeoutController : HttpServlet() {
	
	var timeout = TimeoutExample()

    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.write("Hello, Timeout!\n")
        val path : String = req.getRequestURI()
        println("path called: ${path}")
        
       
        timeout.doSomething(res)
		Thread.sleep(2000L)
    }
    
    
} 


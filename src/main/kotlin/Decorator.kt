package org.example

interface RequestHandler {
    fun sendRequestToServer1()
    fun sendRequestToServer2()
}


class MainRequestHandler() : RequestHandler {
    override fun sendRequestToServer1() {
        println("Send request to server 1")
    }

    override fun sendRequestToServer2() {
        println("Send request to server 2")
    }
}


class DebugRequestHandlerForServer1(private val requestHandler: RequestHandler) : RequestHandler by requestHandler {
    override fun sendRequestToServer1() {
        println("Debug mode ... Start logging ...")
        requestHandler.sendRequestToServer1()
    }
}


fun main() {

    ///////////////////
    // It's all about making same objects with slightly changed behavior
    ///////////////////

    // Class Request handler
    // current methods: SendRequestToServer1, SendRequestToServer2
    // add logging to each method


    val mainRequestHandler = MainRequestHandler()
//    mainRequestHandler.sendRequestToServer1()
//    mainRequestHandler.sendRequestToServer2()
    val debugRequestHandlerForServer1 = DebugRequestHandlerForServer1(mainRequestHandler)
    debugRequestHandlerForServer1.sendRequestToServer1()
    debugRequestHandlerForServer1.sendRequestToServer2()
}
package com.klaxon.examples.laziness

/**
 * <p>date 2/3/14 </p>
 * @author klaxon
 */
object CallByName {

  def main(args: Array[String]) = {
    val consoleLogger = new CoolLogger
    consoleLogger.log(computeMessage)

    val nullLogger = new NullLogger
    nullLogger.log(computeMessage)
  }

  def computeMessage = {
    println("Computing message. Stand by...")
    Thread.sleep(1000)

    "computed message"
  }

}

sealed trait Logger {
  def log(message: => String)
}

class CoolLogger extends Logger{
  def log(message: => String) = {
    println("CoolLogger: " + message)
  }
}

class NullLogger extends Logger {
  def log(message: => String) = {
    println("NullLogger: I don't want to log anything")
  }
}





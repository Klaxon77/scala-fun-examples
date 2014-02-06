package com.klaxon.examples.actor

import scala.actors.Actor

/**
 * <p>date 2/2/14 </p>
 * @author klaxon
 */
object ActorCommunication {

  def main(args: Array[String]) = {
    val reverser = new Reverser().start()

    val helloWorld = reverser !! "Hello world"
    println("Getting future is not blocking operation")
    println(helloWorld())
    println()

    val seventyOne = reverser !! 71
    println(seventyOne())
    println()

    val hundred = reverser !? 100
    println("Getting value is blocking operation")
    println(hundred)

    val timeOutExecution = reverser !? (500, "Time out")
    timeOutExecution match {
      case Some(s) => println(s)
      case None => println("So slow....")
    }

    reverser ! "exit"
  }

}

class Reverser extends Actor {

  def act(): Unit = while (true) {
    Thread.sleep(1000)
    receive {
      case "exit" => exit()
      case s: String => sender ! s.reverse
      case i: Int => sender ! i.abs.toString.reverse.toInt
    }
  }

}

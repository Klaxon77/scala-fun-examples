package com.klaxon.examples.actor

import scala.actors.Actor
import scala.util.Random


/**
 * <p>date 2/2/14 </p>
 * @author klaxon
 */
object ActorExample {

  def main(args: Array[String]) = {
    val actor = new SimpleActor().start()

    println("Starting processing")
    for (number <- 0 until 20) {
      actor ! number
    }
    actor ! "exit"

    println("End processing")
  }

}

class SimpleActor extends Actor {
  def act(): Unit = while (true) {
    receive {
      case x: Int =>
        //Expensive calculation
        println(f"Calculated: $x")
      case "exit" => exit()
    }
  }
}


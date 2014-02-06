package com.klaxon.examples.actor.shop

import scala.actors.Actor

/**
 * <p>User: v.pronyshyn<br/>
 * Date: 11/5/13</p>
 */
class Customer(val id: Int) extends Actor{
  var shorn = false

  def act(): Unit = {
    loop{
      react {
        case Haircut => {
          shorn = true
          println(f"[c] with id $id%s has haircut")
        }
        case _ => println(f"[c] with id $id%s is still hairy")
      }
    }
  }
}

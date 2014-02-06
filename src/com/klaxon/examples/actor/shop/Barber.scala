package com.klaxon.examples.actor.shop

import scala.actors.Actor
import scala.util.Random

/**
 * <p>User: v.pronyshyn<br/>
 * Date: 11/5/13</p>
 */
class Barber extends Actor{

  val r = new Random()

  def act(): Unit = {
    loop {
      react {
        case c:Customer => helpCustomer(c)
        case _ => println("wtf")
      }
    }
  }

  def helpCustomer(c: Customer) {
    if (mailboxSize > 3) {
      println("[b] not enough seats. Customer " + c.id + " away")
      return
    }

    println("[b] cutting hair of customer " + c.id)
    Thread.sleep(100 + r.nextInt(400))
    c ! Haircut
  }

}

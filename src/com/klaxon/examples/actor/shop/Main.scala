package com.klaxon.examples.actor.shop

import scala.actors.Actor._
import scala.util.Random

/**
 * <p>User: v.pronyshyn<br/>
 * Date: 11/4/13</p>
 */
object Main {

  val r = new Random()

  def main(args: Array[String]) = {
    println("[!] starting barber shop simulation")
    val barber = new Barber()
    barber.start()

    val shop = actor {
      println("[!] The shop is open")

      loop {
        react {
          case c: Customer => barber ! c
        }
      }
    }

    val customers = createCustomers()
    println("[!] created " + customers.size + " customers")

    for (c <- customers) {
      c.start()
      shop ! c
      Thread.sleep(r.nextInt(450))
    }

    Thread.sleep(3000)

    val shortCount = customers.count(_.shorn)
    println("[!] " + shortCount + "customers got haircuts today")
  }

  def createCustomers() = for (i <- 0 until 20) yield new Customer(i)

}


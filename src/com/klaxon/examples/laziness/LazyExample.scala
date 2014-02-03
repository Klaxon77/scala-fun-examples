package com.klaxon.examples.laziness

/**
 * <p>date 2/3/14 </p>
 * @author klaxon
 */
object LazyExample {

  def main(args: Array[String]) = {
    val valueHolder = new LazyHolder

    println("Before requesting value...")
    println(valueHolder.value)
    println(valueHolder.value)
  }

}

class LazyHolder {

  lazy val value = calculateValue()

  def calculateValue() = {
    println("Initializing value...")
    "Hello world"
  }

}

package com.klaxon.examples.pimpmylib

/**
 * <p>date 2/6/14 </p>
 * @author klaxon
 */
object PimpExample {

  def main(args: Array[String]) = {
    println(725.reverse)
    println(123.reverse)
  }

  implicit def intToReverser(i: Int): IntReverser = new IntReverser(i)
}

class IntReverser(i: Int) {
  def reverse: Int = i.toString.reverse.toInt
}







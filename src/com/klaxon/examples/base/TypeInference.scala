package com.klaxon.examples.base

/**
 * <p>date 2/6/14 </p>
 * @author klaxon
 */
object TypeInference {

  def main(args: Array[String]): Unit = {
    val i: Int = 100
    println(i)

    val d: Double = 100.2
    println(d)

    val arr: Array[Int]  = Array(200, 140)
    println(arr.mkString(" "))
  }

}

package com.klaxon.examples.collection

import scala.collection.{GenTraversable, GenSeq}

/**
 * <p>date 2/9/14 </p>
 * @author klaxon
 */
object Parallel {

  def main(args: Array[String]) = {
    //For also returns value with help of yield
    val seq = (0 until 1000).toList

    println("Sequential: ")
    measureOperation(seq)

    println("Parallel: ")
    measureOperation(seq.par)
  }
  
  def measureOperation(traversable: GenTraversable[Int]) = {
    val start = System.currentTimeMillis

    traversable.reduce(expansiveCalculation)

    val timeElapsed = System.currentTimeMillis() - start
    println(f"time - $timeElapsed ms")
  }

  def expansiveCalculation(x: Int, y: Int) = {
    Thread.sleep(5)
    x + y
  }
  
}

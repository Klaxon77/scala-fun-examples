package com.klaxon.examples.classes.point


/**
 * <p>date 2/6/14 </p>
 * @author klaxon
 */
object PointUsing {

  def main(args: Array[String]) = {
    val point = SPoint(1, 2)
    println(point)

    val clonedPoint = new SPoint(1, 2)
    println("Are point equal - " + (clonedPoint == point))

    println("Hashcode - " + point.##)
    println("Does have same hashcode - " + (clonedPoint.## == point.##))
  }

}

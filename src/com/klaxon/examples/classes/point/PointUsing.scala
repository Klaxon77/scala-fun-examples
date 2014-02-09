package com.klaxon.examples.classes.point


/**
 * <p>date 2/6/14 </p>
 * @author klaxon
 */
object PointUsing {

  def main(args: Array[String]) = {
    val point = SPoint(1, 2)
    println(point)

    val otherPoint = new SPoint(1, 2)
    println("Are point equal - " + (otherPoint == point))

    println("Hashcode - " + point.##)
    println("Does have same hashcode - " + (otherPoint.## == point.##))
    
    val SPoint(x, y) = point
    println(f"This is result of extractor. x - $x, y - $y")
  }

}

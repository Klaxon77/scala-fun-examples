package com.klaxon.examples.base

/**
 * <p>date 2/5/14 </p>
 * @author klaxon
 */
object PatternMatch {

  def main(args: Array[String]) = {
    tell(1)
    tell(0)
    tell(24)
    tell(73)
    tell(4.3)
    tell("Hello world")
  }

  def tell(a: Any) = a match {
    case 1 | 2 | 3 => println("Well, nice integer!")
    case 0 => println("ZERO")
    case x: Int if x % 2 == 0 => println("EVEN " + x)
    case x: Int => println("Just some ODD integer " + x)
    case _: Double | _:Float => println("Floating point ")
    case _ => println("I don't know what's that")
  }


}

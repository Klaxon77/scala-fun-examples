package com.klaxon.examples.collection

/**
 * <p>date 2/9/14 </p>
 * @author klaxon
 */
object IterableApi {

  def main(args: Array[String]) = {
    val iterable: Iterable[Int] = List(1, 2, 3, 4, 5)
    println("iterable: " + iterable)

    val squared = iterable.map(x => x * x)
    println("Square: " + squared)

    val odd =  iterable.filter(_ % 2 == 1)
    println("Odd: " + odd)

    val partitioned = iterable.partition(_ > 2)
    println("Partition: " + partitioned)

    val niceString = iterable.mkString("~~ ", "|", " --")
    println("mkString: " + niceString)

    val sum = iterable.sum
    println("Sum: " + sum)

    val zipped = iterable.zip(List("Hello", "World", "!"))
    println("Zip: " + zipped)
  }

}

package com.klaxon.examples.laziness

/**
 * <p>date 2/3/14 </p>
 * @author klaxon
 */
object StreamFibonacci {

  def main(args: Array[String]) = {
    val fib = fibonacciStream()
    println(fib)

    println(fib(12))
    println(fib)
  }

  def fibonacciStream(): Stream[Int] = {
    def fibonacci(previous: Int, current: Int): Stream[Int] = {
      previous #:: fibonacci(current, previous + current)
    }

    fibonacci(0, 1)
  }

}

package com.klaxon.examples.text

import scala.io.Source

/**
 * <p>date 2/1/14 </p>
 * @author klaxon
 */
object TextProcessing {

  def main(args: Array[String]) = {
    val lines = Source.fromFile("src/resources/sherlock.txt").getLines()

    val words = map(lines)
    val mapWords = reduce(words)
    
    println(mapWords.toList.sortBy(_._2).reverse.mkString("\n"))
    println(mapWords.foldLeft(0)((sum, count) => sum + count._2))
  }

  def map(lines: Iterator[String]): Iterator[String] = {
    val words = lines.flatMap(_.split("""\W++"""))
    val filteredWords = words.filter(_.length > 0)
    filteredWords.map(_.toLowerCase)
  }

  def reduce(words: Iterator[String]): Map[String, Int] = {
    val map = Map[String,Int]()
    words.foldLeft(map)((m, word) => m + (word -> m.getOrElse(word, 0).+(1)))
  }

}

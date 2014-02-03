package com.klaxon.examples.text

import scala.io.Source

/**
 * <p>date 2/1/14 </p>
 * @author klaxon
 */
object TextProcessing {

  def main(args: Array[String]) = {
    val lines = Source.fromFile("src/resources/sherlock.txt").getLines()

    val words = wordsFrom(lines)
    val wordMap = wordCountMap(words)
    
    println(wordMap.toList.sortBy(_._2).reverse.mkString("\n"))
    println(wordMap.foldLeft(0)((sum, count) => sum + count._2))
  }

  def wordsFrom(lines: Iterator[String]): Iterator[String] = {
    val words = lines.flatMap(_.split("""\W++"""))
    val filteredWords = words.filter(_.length > 0)
    filteredWords.map(_.toLowerCase)
  }

  def wordCountMap(words: Iterator[String]): Map[String, Int] = {
    val map = Map[String,Int]()
    words.foldLeft(map)((m, word) => m + (word -> m.getOrElse(word, 0).+(1)))
  }

}

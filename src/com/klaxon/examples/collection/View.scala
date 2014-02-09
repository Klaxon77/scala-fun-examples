package com.klaxon.examples.collection

/**
 * <p>date 2/9/14 </p>
 * @author klaxon
 */
object View {

  def main(args: Array[String]) = {
    val view = List("View", "is", "lazy", "collection").view

    //We don't want to calculate it right now, but at later time.
    val vowels: Iterable[String] = view.map(toLowerCase).map(toVowels)

    println("Using the view:")
    println(vowels.toList)
  }

  def toLowerCase(str: String): String = {
    val lowerCase = str.toLowerCase
    println(f"Lowercase: $str => $lowerCase")
    lowerCase
  }

  def toVowels(str: String): String = {
    val vowels = str.filter {
      case 'a' | 'e' | 'i' | 'o' | 'u' => true
      case _ => false
    }.mkString("")

    println(f"Vowels: $str => $vowels")
    vowels
  }

}

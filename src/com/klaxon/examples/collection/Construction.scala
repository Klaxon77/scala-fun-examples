package com.klaxon.examples.collection

/**
 * <p>date 2/9/14 </p>
 * @author klaxon
 */
object Construction {

  def main(args: Array[String]) = {
    val list = List(1, 2, 3, 4)
    println(list)

    val set = Set(5, 5, 7, 8, 8)
    println(set)

    val map = Map(
      "Smith" -> "NY, Brooklyn",
      "Lee" -> "Boston, "
    )
    println(map)

    val complicatedMap = Map(
      "Smith" -> List("NY", "Brooklyn", "42"),
      "Lee" -> List("Boston", "Melrose", " 11 ")
    )
    println(complicatedMap)
  }

}

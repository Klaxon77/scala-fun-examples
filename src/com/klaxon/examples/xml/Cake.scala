package com.klaxon.examples.xml

import scala.xml.Elem

/**
 * <p>date 1/30/14 </p>
 * @author klaxon
 */
object Cake {

  val cakeXml =
    <Cake size="huge" form="square" color="cheezy">
      <Name>Cheesecake</Name>
      <Description>Sooo delicious...</Description>
      <Ingredients>
        <Ingredient amount="200" measurement="gr">chocolate</Ingredient>
        <Ingredient amount="100" measurement="gr">cream</Ingredient>
        <Ingredient amount="50" measurement="gr">cocoa</Ingredient>
        <Ingredient amount="3" measurement="spoon">sugar</Ingredient>
        <Ingredient amount="4" measurement="piece">egg</Ingredient>
        <Ingredient amount="1" measurement="piece">cherry</Ingredient>
      </Ingredients>
    </Cake>

  def main(args: Array[String]) = {
    println("--Cake--" * 8)

    val name = (cakeXml \ "Name").text
    println(name)

    val description = (cakeXml \ "Description").text
    println(f"People say : $description")

    val attributes = cakeXml.attributes.map(attr => attr.value).mkString(" and ")
    println(f"Wow, it's $attributes")

    val ingredients = cakeXml \ "Ingredients" \\ "Ingredient" map (node => node.text) mkString ", "
    println(f"To do $name you just need: $ingredients")

    val weight = weightOf(cakeXml)
    println(f"Can you eat $weight grams of it at once?")

    println("--Cake--" * 8)
  }

  def weightOf(cakeElem: Elem): Int = {
    val ingredients = cakeElem \ "Ingredients" \\ "Ingredient"
    val ingredientsInGrams = ingredients.filter(node => (node \ "@measurement").text == "gr")
    ingredientsInGrams.map(node => (node \ "@amount").text.toInt).sum
  }

}

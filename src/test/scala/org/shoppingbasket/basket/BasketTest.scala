package org.shoppingbasket.basket

import org.scalatest.{FunSuite, Matchers}
import Item._
import org.shoppingbasket.utils.EmptyInputException

class BasketTest extends FunSuite with Matchers{

  test("processing a list of valid items"){

    val listOfItems = Seq("Soup", "Bread", "Milk", "Apples")

    val basket = Basket(listOfItems)

    val processedItems = basket.getProcessedItems

    val expectedItemsInBasket = Map(
      Soup -> 1,
      Bread-> 1,
      Milk-> 1,
      Apples-> 1
    )

    processedItems should contain theSameElementsAs expectedItemsInBasket

  }

  test("processing a list with invalid items"){

    val listOfItems = Seq("Soup", "Bread", "Coca-cola", "123456")

    val basket = Basket(listOfItems)

    val processedItems = basket.getProcessedItems

    // invalid items should be excluded
    val expectedItemsInBasket = Map(
      Soup -> 1,
      Bread-> 1
    )

    processedItems should contain theSameElementsAs expectedItemsInBasket
  }

  test("processing a list with duplicate items"){

    val listOfItems: Seq[String] = Seq("Apples", "Soup", "Bread", "Soup", "Apples", "Soup", "Bread", "Soup", "Milk")

    val basket: Basket = Basket(listOfItems)

    val processedItems = basket.getProcessedItems

    val expectedItemsInBasket = Map(
      Soup -> 4,
      Bread-> 2,
      Milk-> 1,
      Apples-> 2
    )

    processedItems should contain theSameElementsAs expectedItemsInBasket
  }

  test("processing an empty list"){

    val listOfItems = Seq()

    an [EmptyInputException] should be thrownBy Basket(listOfItems)

  }

}

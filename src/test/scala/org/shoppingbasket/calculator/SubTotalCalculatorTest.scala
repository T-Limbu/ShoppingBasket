package org.shoppingbasket.calculator

import org.scalatest.{FunSuite, Matchers}
import org.shoppingbasket.basket.Item
import org.shoppingbasket.basket.Item._

class SubTotalCalculatorTest extends FunSuite with Matchers {

  test("calculate subtotal with a single all valid item"){

    val itemCounter: Map[Item, Int] = Map(
      Soup-> 1,
      Bread-> 1,
      Milk-> 1,
      Apples-> 1
    )

    val calculator = new SubTotalCalculator(itemCounter)
    calculator.calculateSubTotal()

    val subTotal = calculator.getTotal

    val expectedTotal: Double = 3.75

    subTotal shouldBe expectedTotal
  }

  test("calculate subtotal with multiple input of multiple valid item"){

    val itemCounter: Map[Item, Int] = Map(
      Soup-> 2,
      Bread-> 3,
      Milk-> 2,
      Apples-> 5
    )

    val calculator = new SubTotalCalculator(itemCounter)
    calculator.calculateSubTotal()

    val subTotal = calculator.getTotal

    val expectedTotal: Double = 11.3

    subTotal shouldBe expectedTotal
  }

  test("calculate subtotal with an input of multiple valid item"){

    val itemCounter: Map[Item, Int] = Map(
      Soup-> 2,
      Bread-> 3,
      Milk-> 2,
      Apples-> 5
    )

    val calculator = new SubTotalCalculator(itemCounter)
    calculator.calculateSubTotal()

    val subTotal = calculator.getTotal

    val expectedTotal: Double = 11.3

    subTotal shouldBe expectedTotal
  }

}

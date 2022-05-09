package org.shoppingbasket.calculator

import org.scalatest.{FunSuite, Matchers}
import org.shoppingbasket.basket.Item
import org.shoppingbasket.basket.Item._

class FinalPriceCalculatorTest extends FunSuite with Matchers {

  test("discount should be applied for purchase of 1 lot of apples"){

    val itemCounter: Map[Item, Int] = Map(
      Apples ->  1)

    val calculator = new FinalPriceCalculator(itemCounter)

    calculator.calculateSubTotal()
    calculator.applyDiscount()

    val finalTotal = calculator.getFinalTotal

    val expectedTotal: String = "0.90"

    f"$finalTotal%1.2f" shouldBe expectedTotal
  }

  test("discount should be applied for purchase of multiple lot of apples"){

    val itemCounter: Map[Item, Int] = Map(
      Apples ->  20)

    val calculator = new FinalPriceCalculator(itemCounter)

    calculator.calculateSubTotal()
    calculator.applyDiscount()

    val finalTotal = calculator.getFinalTotal

    val expectedTotal: String = "18.00"

    f"$finalTotal%1.2f" shouldBe expectedTotal
  }

  test("discount should be applied for 1 loaf of bread with 2 tins of soup"){

    val itemCounter: Map[Item, Int] = Map(
      Bread ->  1,
      Soup -> 2
    )

    val calculator = new FinalPriceCalculator(itemCounter)

    calculator.calculateSubTotal()
    calculator.applyDiscount()

    val finalTotal = calculator.getFinalTotal

    val expectedTotal: String = "1.70"

    f"$finalTotal%1.2f" shouldBe expectedTotal
  }

  test("discount should be applied for 1 loaf of bread with 2 tins of soup but the basket contains extra 2 Breads"){

    val itemCounter: Map[Item, Int] = Map(
      Bread ->  3,
      Soup -> 2
    )

    val calculator = new FinalPriceCalculator(itemCounter)

    calculator.calculateSubTotal()
    calculator.applyDiscount()

    val finalTotal = calculator.getFinalTotal

    val expectedTotal: String = "3.30"

    f"$finalTotal%1.2f" shouldBe expectedTotal
  }

  test("discount should be applied for 1 loaf of bread with 4 tins of soup"){

    val itemCounter: Map[Item, Int] = Map(
      Bread ->  1,
      Soup -> 4
    )

    val calculator = new FinalPriceCalculator(itemCounter)

    calculator.calculateSubTotal()
    calculator.applyDiscount()

    val finalTotal = calculator.getFinalTotal

    val expectedTotal: String = "3.00"

    f"$finalTotal%1.2f" shouldBe expectedTotal
  }

}

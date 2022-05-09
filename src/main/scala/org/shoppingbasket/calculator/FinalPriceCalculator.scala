package org.shoppingbasket.calculator

import org.shoppingbasket.basket.Item
import org.shoppingbasket.utils.Util

class FinalPriceCalculator(itemCounter: Map[Item, Int])
  extends SubTotalCalculator(itemCounter: Map[Item, Int])
    with Discount {

  private var discountedTotal: Double = 0
  def getDiscountedTotal: Double = discountedTotal

  private var finalTotal: Double = _
  def getFinalTotal: Double ={
    println(s"Total price: ${Util.currencyConvert(finalTotal)}")
    finalTotal
  }

  override def applyDiscount(): Unit = {

    // apples discount logic

    val itemKeys: Set[Item] = itemCounter.keys.toSet

    if (itemKeys.contains(Item.Apples))
    {
      val a: Integer = itemCounter(Item.Apples)
      val discountedVal = (Item.Apples.price * 0.1) * a

      discountedTotal = discountedTotal + discountedVal
      println(s"Apples 10% off: ${Util.currencyConvert(discountedVal)}")
    }

    // bread discount logic

    if( (itemCounter.getOrElse(Item.Soup, 0) > 1) && itemCounter.getOrElse(Item.Bread, 0) > 0)
    {
      val noOfBreadThatCanBeDiscounted: Int = itemCounter(Item.Soup) / 2

      if (noOfBreadThatCanBeDiscounted > itemCounter(Item.Bread) ){
        val discountedVal = itemCounter(Item.Bread) * (Item.Bread.price / 2)
        discountedTotal = discountedTotal + discountedVal
        println(s"Bread half price: ${Util.currencyConvert(discountedVal)}")
      }
      else {
        val discountedVal = noOfBreadThatCanBeDiscounted * (Item.Bread.price / 2)
        discountedTotal = discountedTotal + discountedVal
        println(s"Bread half price: ${Util.currencyConvert(discountedVal)}")
      }
    }

    // printing message if no discount
    if(discountedTotal == 0)
      {
        println("(No offers available)")
      }

    finalTotal = getTotal - discountedTotal
  }

}


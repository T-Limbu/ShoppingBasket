package org.shoppingbasket.calculator

import org.shoppingbasket.basket.Item
import org.shoppingbasket.utils.Util

class SubTotalCalculator(itemCounter: Map[Item, Int]) extends PriceCalculator {

  private var total: Double = _
  def getTotal: Double = total

  override def calculateSubTotal(): Unit = {
    total = itemCounter.map(x => {
      x._1.price * x._2
    }).sum

    println(s"Subtotal: ${Util.currencyConvert(total)}")
  }

}

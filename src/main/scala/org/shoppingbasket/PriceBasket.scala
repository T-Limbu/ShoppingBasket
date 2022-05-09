package org.shoppingbasket

import org.shoppingbasket.basket.Basket
import org.shoppingbasket.utils.EmptyInputException

object PriceBasket {
  def main(args: Array[String]): Unit = {

    try {
      Basket(args)
    }
    catch {
      case e: EmptyInputException => println(e.getMessage)
    }

  }
}

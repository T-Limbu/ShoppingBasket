package org.shoppingbasket

import org.shoppingbasket.basket.Basket
import org.shoppingbasket.utils.EmptyInputException

object PriceBasket extends App{
    try {
      Basket(args)
    }
    catch {
      case e: EmptyInputException => println(e.getMessage)
    }
}

package org.shoppingbasket.basket

import org.shoppingbasket.calculator.Price

sealed trait Item extends Price

object Item {

  case object Soup extends Item {
    override val price: Double = .65
  }

  case object Bread extends Item {
    override val price: Double = .80
  }

  case object Milk extends Item {
    override val price: Double = 1.3
  }

  case object Apples extends Item {
    override val price: Double = 1.0
  }

}

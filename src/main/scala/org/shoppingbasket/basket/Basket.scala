package org.shoppingbasket.basket

import org.shoppingbasket.calculator.FinalPriceCalculator
import org.shoppingbasket.utils.EmptyInputException

object Basket{

  def apply(items: Seq[String]):Basket ={

    // checking for empty inputs
    if(items.size < 1)
      throw new EmptyInputException

    val basket = new Basket
    basket.processItems(items)

    val finalPriceCalculator = new FinalPriceCalculator(basket.getProcessedItems)

    finalPriceCalculator.calculateSubTotal()
    finalPriceCalculator.applyDiscount()
    finalPriceCalculator.getFinalTotal

    basket
  }

}

class Basket {

  private var processedItems: Map[Item, Int] = _

  def getProcessedItems: Map[Item, Int] = processedItems

  private def processItems(items: Seq[String]): Unit = {

    // input is case-sensitive, but can be updated to be case-insensitive if required
    processedItems = items.map{
      case "Soup" => Item.Soup
      case "Bread" => Item.Bread
      case "Milk" => Item.Milk
      case "Apples" => Item.Apples
      case _ =>
    }
      .filterNot(_.equals())
      .groupBy(identity).mapValues(_.size)
      .map(x => x._1.asInstanceOf[Item] -> x._2)
  }

}

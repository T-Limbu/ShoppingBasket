package org.shoppingbasket.utils

import java.util.Locale

object Util {

  def currencyConvert(input: Double): String = {

    val formatter = java.text.NumberFormat.getCurrencyInstance(Locale.UK)

    if (input < 1) {
      val pence = input * 100
      f"$pence%1.0fp"
    }
    else {
      formatter.format(input)
    }
  }

}

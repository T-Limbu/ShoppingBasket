package org.shoppingbasket.utils

import org.scalatest.{FunSuite, Matchers}

class UtilTest extends FunSuite with Matchers{

  test("converting inputs into pence"){

    Util.currencyConvert(0.01) shouldBe "1p"
    Util.currencyConvert(0.1) shouldBe "10p"
    Util.currencyConvert(0.50) shouldBe "50p"
    Util.currencyConvert(0.99) shouldBe "99p"
  }

  test("converting inputs into string with £ sign"){

    Util.currencyConvert(1.01) shouldBe "£1.01"
    Util.currencyConvert(12345.1) shouldBe "£12,345.10"
    Util.currencyConvert(12.55) shouldBe "£12.55"
  }

}

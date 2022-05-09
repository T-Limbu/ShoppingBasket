package org.shoppingbasket.utils

final case class EmptyInputException(private val message: String = "Please provide at least one item") extends Exception(message)

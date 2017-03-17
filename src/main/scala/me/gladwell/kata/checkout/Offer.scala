package me.gladwell.kata.checkout

case class Offer(sku: String, products: Seq[ShoppingItem], discount: Double)

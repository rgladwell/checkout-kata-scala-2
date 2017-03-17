package me.gladwell.kata.checkout

import scala.annotation.tailrec

class ShoppingBasket(offers: Offer*) {

  @tailrec
  private def countOffers(offer: Offer, sublist: Seq[ShoppingItem], count: Int): Int = {
    val index = sublist.indexOfSlice(offer.products)

    if(index == -1) count
    else countOffers(offer, sublist.slice(index + offer.products.size, sublist.size), count + 1)
  }

  def applyOffers(items: Seq[ShoppingItem]): Seq[ShoppingItem] = {
    val discounts =
      for {
        offer <- offers
      } yield {
        val discounts = countOffers(offer, items, 0)
        val discount = ShoppingItem(offer.sku, -offer.discount)
        Seq.fill(discounts)(discount)
      }

    items ++ discounts.flatten
  }

  def checkout(items: ShoppingItem*): BigDecimal = {
    val discountedItems = applyOffers(items.sortBy(_.sku))
    discountedItems.map(_.price).sum
  }

}

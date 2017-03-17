package me.gladwell.kata.checkout

class ShoppingBasket(offer: Offer) {

  private implicit class AllSeq[T](seq: Seq[T]) {

    def containsAll(elems: T*): Boolean =
      elems
        .map(seq.contains(_))
        .foldLeft(true)(_ && _)

    def removeFirst(elem: T): Seq[T] = {
      val index = seq.indexOf(elem)
      seq.take(index + 1) ++ seq.drop(index + 1)
    }

    def removeAll(elems: T*): Seq[T] = elems match {
      case elem :: tail => seq.removeFirst(elem) ++ removeAll(tail:_*)
      case Nil          => seq
    }

  }

  private def applyOffers(items: Seq[ShoppingItem]): Seq[ShoppingItem] = {
    items
  }

  def checkout(items: ShoppingItem*): Double =
    applyOffers(items).map(_.price).sum

}

import org.specs2.mutable.Specification
import me.gladwell.kata.checkout._

object ShoppingBasketSpec extends Specification {

  "Shopping basket should" >> {

    val apple = ShoppingItem("apple", 0.60)
    val orange = ShoppingItem("orange", 0.25)

    val buyOneGetOneFreeApples = Offer("discount1", Seq(apple, apple), apple.price)

    val basket = new ShoppingBasket(buyOneGetOneFreeApples)

    "return total price of items" >> {
      basket.checkout(apple, orange) must_== 0.85
    }

//    "discount total price for buy one get one free apples" >> {
//      basket.checkout(apple, apple) must_== 0.60
//    }
//
//    "apply discount multiple times" >> {
//      basket.checkout(apple, apple, orange, apple, apple) must_== 1.45
//    }

  }

}

import org.specs2.mutable.Specification
import me.gladwell.kata.checkout._

object ShoppingBasketSpec extends Specification {

  "Shopping basket should" >> {

    val apple = ShoppingItem("apple", .60)
    val orange = ShoppingItem("orange", .25)

    val buyOneGetOneFreeApples = Offer("bogof", Seq(apple, apple), apple.price)
    val threeForTwoOranges = Offer("3for2", Seq(orange, orange, orange), orange.price)

    val basket = new ShoppingBasket(buyOneGetOneFreeApples, threeForTwoOranges)

    "return total price of items" >> {
      basket.checkout(apple, orange) must_== .85
    }

    "discount total price for buy one get one free apples" >> {
      basket.checkout(apple, apple) must_== .60
    }

    "apply discount to non-sequential items" >> {
      basket.checkout(apple, orange, apple) must_== .85
    }

    "apply discount multiple times" >> {
      basket.checkout(apple, apple, orange, apple, apple) must_== 1.45
    }

    "handle multiple discounts" >> {
      basket.checkout(orange, orange, orange) must_== .50
    }

    "apply multiple discounts" >> {
      basket.checkout(orange, apple, orange, orange, apple) must_== 1.10
    }

  }

}

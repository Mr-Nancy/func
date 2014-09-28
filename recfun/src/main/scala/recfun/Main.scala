package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def number(c: Int, r: Int): Int =
      if ((c == r) || (c == 0)) 1
      else number(c - 1, r - 1) + number(c, r - 1)

    number(c, r)
  }
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def iter(chars: List[Char], count: Int): Boolean =
      if (!chars.isEmpty)
        if (count < 0) false
        else if (chars.head == '(') iter(chars.tail, count + 1)
        else if (chars.head == ')') iter(chars.tail, count - 1)
        else iter(chars.tail, count)
      else (count == 0)

    iter(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def ways(amount: Int, coins: List[Int]): Int = {
      if (amount == 0) 1
      else if ((amount < 0) || (coins.isEmpty)) 0
      else ways(amount, coins.tail) + ways(amount - coins.head, coins)
    }
    ways(money, coins)
  }
}

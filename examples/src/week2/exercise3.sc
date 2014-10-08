package week2

object exercise3 {
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
                                                  
  def fact(n: Int) = product (x=>x)(1, n)         //> fact: (n: Int)Int
  
  fact(5)                                         //> res0: Int = 120
}
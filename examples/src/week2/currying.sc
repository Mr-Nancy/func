package week2

object currying {
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int
  def fact(x: Int): Int = if (x == 0) 1 else x*fact(x - 1)
                                                  //> fact: (x: Int)Int

  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int
  def sumFactorials = sum(fact)                   //> sumFactorials: => (Int, Int) => Int

  sumCubes(1, 10) + sumFactorials(10, 20)         //> res0: Int = 267634641
  sumFactorials(10, 20)                           //> res1: Int = 267631616
  sum(cube)(1, 10)                                //> res2: Int = 3025
  sumCubes(1, 10)                                 //> res3: Int = 3025
 
  
}
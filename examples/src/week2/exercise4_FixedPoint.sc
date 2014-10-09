package week2

import math.abs

object exercise4_FixedPoint {

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) / x < tolerance
                                                  //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
       println("guess is:" + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  def sqrt(x: Double) = fixedPoint(y => x/y)(1)   //> sqrt: (x: Double)Double
  
}
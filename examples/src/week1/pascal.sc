package week1

object pascal {

  def pascal(col: Int, row: Int): Int = {
    
    def number(c: Int, r: Int): Int =
      if ((c == r) || (c == 0)) 1
      else number(c - 1, r - 1) + number(c, r - 1)

    number(col, row)
  }                                               //> pascal: (col: Int, row: Int)Int

  pascal(1, 3)                                    //> res0: Int = 3
  pascal(163, 165)                                //> res1: Int = 13530
}
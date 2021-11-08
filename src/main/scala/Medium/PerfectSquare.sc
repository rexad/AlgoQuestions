import scala.collection.mutable

/*
*
*
* Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.



Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


Constraints:

1 <= n <= 104
*
* */



object Solution {
  var dict = Map[Int, Int]()
  var q = mutable.Queue[Int]()
  def numSquares(n: Int): Int = {
    if(scala.math.sqrt(n)% 1 == 0) return n
    else {
      val list = extractRoot(n)
      list.map(println(_))
      q.enqueueAll(list)
      for(i <- list.indices) dict = dict + (list(i) -> 1)

      while(q.nonEmpty) {
        var node = q.dequeue()
        //println("#########")
        //println(node)
        //println("********")
        val deep: Int = dict(node)
        for(i <- list.length-1 to 0 by -1) {
          val newNode = node + list(i)

         //println(newNode)

          if(newNode == n ) return deep + 1
          if(!dict.contains(newNode) || dict(newNode) > deep + 1) {
            dict = dict + (newNode -> (deep+1))
            q.enqueue(newNode)
          }

        }
      }
      -1
    }

  }
  def extractRoot(n: Int): List[Int] = {
    var list = List[Int]()
    for(i <- 1 until n) if(scala.math.sqrt(i)% 1 == 0) list = i :: list
    list
  }
}




Solution.numSquares(28)

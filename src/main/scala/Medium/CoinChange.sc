/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 */

import scala.collection.mutable.Map

object Solution {
  var dict: Map[Int, Int] = Map[Int, Int]()
  var maxCoins = Int.MaxValue

  var s = 0
  def coinChange(coins: Array[Int], amount: Int): Int = {
    dict= Map[Int, Int]()
    maxCoins = Int.MaxValue


    explore(coins.sortWith(_<_), amount, 0)
    println(s)
    if(maxCoins == Int.MaxValue) -1
    else maxCoins
  }

  def explore (coins: Array[Int], amountLeft: Int, nbCoins: Int) : Boolean = {
    if(amountLeft == 0)
    {
      maxCoins = Math.min(nbCoins, maxCoins)
      return true
    }

    if(amountLeft < 0)
      return true


    if(dict.contains(amountLeft)) {
      val coins = dict(amountLeft)
      if(nbCoins < coins ) dict = dict + (amountLeft -> nbCoins)

    }
    else {
      dict = dict + (amountLeft -> nbCoins)
    }



    for(i <- coins.length - 1 to 0 by -1)
      {
        s = s+ 1
        explore(coins, amountLeft - coins(i), nbCoins + 1)
      }

    true
  }

}

object Solution2 {

  def coinChange(coins: Array[Int], amount: Int): Int = {
    val mem = scala.collection.mutable.HashMap.empty[Int, Option[Int]]

    def cc(coins: List[Int], amount: Int): Option[Int] = {
      println(amount)
      mem.foreach(print(_))
      println("######")
      if (mem.contains(amount)) mem(amount)
      else {
        val response =
          if (amount < 0) None                 //This is the Juicy part
          else if (amount == 0) Some(0)
          else coins.flatMap(
            c =>
              {
                println("minus " + c)
                var a = cc(coins, amount - c).map(_ + 1)
                println("result " + a)
                a
              }
          ).minOption

        mem.put(amount, response)
        response
      }
    }
    cc(coins.toList, amount).getOrElse(-1)
  }
}

Solution2.coinChange(Array( 2, 3, 4), 11)
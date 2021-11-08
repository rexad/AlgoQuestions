

/*
*
* Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*
* */
import scala.collection.mutable
object Solution {
  var s = mutable.Stack[(Int, Int)]()
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val result = Array.fill(temperatures.length)(0)

    s.push((temperatures(0), 0))
    for(i <- 1 until temperatures.length){
      while(s.nonEmpty && temperatures(i) > s.top._1) {
        result(s.top._2) = i-s.top._2
        s.pop()
      }

      if((i+1) < temperatures.length && temperatures(i) < temperatures(i + 1)) result(i) = 1
      else s.push((temperatures(i), i))

    }
    result
  }
}

Solution.dailyTemperatures(Array(30, 60, 90))
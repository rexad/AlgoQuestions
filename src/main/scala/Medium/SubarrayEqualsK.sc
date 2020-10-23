

/*
* Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2



Constraints:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*/
import scala.collection.mutable
object Solution {

  var cumulative = mutable.Map[Int, Int]()
  def subarraySum(nums: Array[Int], k: Int): Int = {
    var result = 0
    var sum = 0
    cumulative = mutable.Map[Int, Int](0 -> 1)

    for(i <- nums.indices){
      sum = sum + nums(i)
      result = result + cumulative.getOrElse(sum - k, 0)

      cumulative = cumulative ++ Map(sum -> (cumulative.getOrElse(sum, 0) + 1))
    }
    result
  }
}

Solution.subarraySum(Array(-1, -1, 1), 0)
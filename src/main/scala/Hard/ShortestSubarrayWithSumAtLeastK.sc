import scala.collection.mutable

/*

Return the length of the shortest, non-empty, contiguous subarray of nums with sum at least k.

If there is no non-empty subarray with sum at least k, return -1.

Example 1:

Input: nums = [1], k = 1
Output: 1
Example 2:

Input: nums = [1,2], k = 4
Output: -1
Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3


Note:
1 <= nums.length <= 50000
-105 <= nums[i] <= 105
1 <= k <= 109
*
* */


object Solution {
  def shortestSubarray(nums: Array[Int], k: Int): Int = {

    val temp = mutable.ArrayDeque[Int]()
    val cumulative = Array.fill(nums.length+1){0}
    var result = nums.length+1
    cumulative(0) = 0
    for(i <- nums.indices) {
      cumulative(i+1) = cumulative(i) + nums(i)
    }

    for(el <- cumulative.indices){

      while(temp.nonEmpty && cumulative(el) < cumulative(temp.last)) {
        temp.removeLast()
      }

      while(temp.nonEmpty  && cumulative(el) - cumulative(temp.head) >= k) {
        result = result.min(el - temp.removeHead())
      }

      temp.addOne(el)
    }

    if(result == nums.length + 1) -1 else result

  }
}

Solution.shortestSubarray(Array(-47,45,92,86,17,-22,77,62,-1,42), 180)


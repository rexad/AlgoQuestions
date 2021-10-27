import scala.util.control.Breaks.break

/*

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].


Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500W
-104 <= nums[i] <= 104


Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
* */


object Solution {
  var dict = Map[Int, Int]()

  def lengthOfLIS(nums: Array[Int]): Int = {
    dict = Map[Int, Int]()
    var max = 0
    for(i <- nums.length-1 to 0 by -1)
      {
        val maxSep = explore(i, nums, 1)
        dict = dict + (i -> maxSep)
        max = Math.max(maxSep, max)
      }
    max
  }


  def explore(index: Int, nums: Array[Int], cumul: Int): Int = {


      var max = 0
      for(i <- index+1 until  nums.length)
      {
          if(nums(index) < nums(i)) {





            
          }
      }
    Math.max(cumul, max)
  }
}

//Solution.explore(5, Array(1,3,6,7,9,4,10,5,6),1)

Solution.lengthOfLIS(Array(1,3,6,7,9,4,10,5,6))
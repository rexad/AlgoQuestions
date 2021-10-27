/*
*
*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*
*
* */


object Solution {
  var cache = collection.mutable.Map[Int, Int]()
  var result =Set[List[Int]]()
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    cache = collection.mutable.Map[Int, Int]()
    result =Set[List[Int]]()
    for(i <- nums.indices) {cache = cache + (nums(i) -> i)}
    for(i <- nums.indices) TwoSum(i, nums)
    result.toList
  }

  def TwoSum(index: Int, nums: Array[Int]) = {
    for(i <- nums.indices) {
      if(i != index) {
        result = cache.get(-(nums(index) + nums(i))).fold(result)(
          v => if(v != index && v!= i)
            result + List(nums(index), nums(i), nums(v)).sortWith(_<_)
          else result
        )
      }
    }
  }
}

Solution.threeSum(Array(0, 1, 1))
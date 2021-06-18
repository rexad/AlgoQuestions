import scala.collection.immutable.HashSet

/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.



Example 1:

  Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

  Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

  0 <= nums.length <= 104
-109 <= nums[i] <= 109


Follow up: Could you implement the O(n) solution?*/

object Solution {
  def longestConsecutive(nums: Array[Int]): Int = {

    val distinct = nums.distinct
    if(distinct.length == 1) return 1
    val sorted = distinct.sortWith(_ < _)

  val result = sorted.foldLeft((-200, 0 , 0)){(acc, curr)=> {

    if(acc._1 == curr) (curr, acc._2, acc._3)
    else {
    if(acc._1 == curr - 1) (curr, acc._2+1, acc._3)
     else  (curr, 0, (acc._2+1).max(acc._3))

    }}
  }

    if(result._2> 0)
      (result._2+1).max(result._3)
    else result._3
  }



  var visited: HashSet[Int] = HashSet[Int]()
  def longestConsecutiveWithMap(nums: Array[Int]): Int = {
    var hs: HashSet[Int] = HashSet(1, 2, 3)

    var max = 0
    for(e <- nums ){
      if(visited.contains(e)) {
        val res = explore(e, hs)
        max = max.max(res)
      }
    }
    max
  }

  def explore (value: Int, set: HashSet[Int]) : Int = {
    if(!set(value)) 0
    else
      {
        visited = visited + value
        explore(value+1, set) + explore(value-1, set) + explore(value+1, set) + explore(value+1, set)
      }
  }

}
Solution.longestConsecutiveWithMap(Array(-6,-1,-1,9,-8,-6,-6,4,4,-3,-8,-1))
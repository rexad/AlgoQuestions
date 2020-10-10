object Solution {
  def nextPermutation(nums: Array[Int]): Unit = {
    var pivot = nums.length - 1
    while(pivot >= 1 && nums(pivot)<= nums(pivot-1))  pivot= pivot-1
    if (pivot == 0) return nums
    val value = getMin(nums, pivot-1)
  }
  def getMin(nums: Array[Int], index: Int): Unit = {
    
  }

  def sortInPlace (nums: Array[Int], index: Int): Unit = {

  }
}
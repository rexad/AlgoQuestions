object Solution {


  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var elements:Map[Int,List[Int]] = Map()
    for(i <- nums.indices) {
      if(!elements.contains(nums(i)))
      elements += (nums(i) -> List[Int](i))
      else elements += (nums(i) -> (i :: elements(nums(i))))
    }

    for(i <- nums.indices) {
      val lookupValue = target - nums(i)
      if ( elements.contains(lookupValue))
        {
          elements(lookupValue).find(x => x != i).fold()( x => return Array[Int](i, x))

        }
    }
    Array[Int]()
  }
}
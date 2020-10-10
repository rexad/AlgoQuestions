object Solution {
  def consecutiveNumbersSum(N: Int): Int = {
    var diff = findLimit(N) - N
    var k = 0
    while(k < N) {
      k = k + (k+1)
    }
    
  }

  def findLimit(N: Int): Int = {

    var k = 0
    while(k < N)
      k = k + (k+1)

    k
  }
}

println("test")
object SolutionBruteForce {

  def validPalindrome(s: String): Boolean = {
    if(isPalindrome(s)) return true
    for( i <- 0 to s.length-1) {
      if (isPalindrome(s.substring(0, i) + s.substring(i+1, s.length)))
        return true
    }
      return false
  }

  def isPalindrome(t: String) : Boolean = {

    val l = t.length
    for( i <- 0 to l/2){
      if(t(i) != t(l -1 - i)) return false
    }

    return true
  }

}


object SolutionRecursions {

  def validRangePalindrome(s: String, i: Int, j: Int): Boolean = {


    for (k <- i  to i + (j - i ) / 2) {
      println(i)
      println(j)
      if (s.charAt(k) != s.charAt(j - k + i)) return false;
    }

    return true;
  }

  def validPalindrome(s: String) : Boolean = {

    val l = s.length
    for( i <- 0 to l/2){
      if(s(i) != s(l -1 - i)) {
        val j = l -1 - i
        return validRangePalindrome(s, i+1, j) || validRangePalindrome(s, i, j-1)
      }
    }

    return true
  }

}


SolutionRecursions.validPalindrome("abc")
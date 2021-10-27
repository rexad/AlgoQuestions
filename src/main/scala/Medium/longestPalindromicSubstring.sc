/*
*
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
* */

/*

 */
object Solution {
  def longestPalindrome(s: String): String = {
    if(s.length == 1) return ""
    var max = 0
    var maxPal = ""
    for(i <- 0 until  s.length) {
      if(i <= (s.length - 2) && s(i) == s(i+1)) {
        var lengthPal = explore(s, i-1, i+2)
        println("#" + lengthPal)
        println(i)
        if(lengthPal  > max) {
          max = lengthPal
          maxPal = s.substring(i- ((lengthPal-2)/2), i + lengthPal/2 +1 )
        }
      }
      if(i < (s.length - 1)) {
        var lengthPal = explore(s, i-1, i+1)
        if(lengthPal  > max) {
          max = lengthPal
          println(i)
          println(lengthPal)
          maxPal = s.substring(i - lengthPal/2, i + lengthPal/2 +1  )
        }
      }
    }
    maxPal
  }

  def explore(s:String, l: Int, r: Int): Int = {
    println(l + "#" + r)
    if(l >= 0 && r < s.length && s(l) == s(r)) explore(s, l-1, r+1)
    else (r - l - 1)
  }
}

Solution.longestPalindrome("ccd")
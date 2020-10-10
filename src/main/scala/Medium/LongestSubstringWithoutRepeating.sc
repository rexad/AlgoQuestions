import scala.collection.mutable

/*
* Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:

Input: s = ""
Output: 0
*
* */
object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    if(s.length == 0) return 0
    if(s.length == 1) return 1
    var globalLength = 0
    var uniqueChar: scala.collection.mutable.Map[Char,Int] = mutable.Map()
    var initialSubString = 0
    var i = 0
    while(i < s.length) {
      val exist = uniqueChar.get(s(i))
      if(exist.isDefined) {
        uniqueChar = uniqueChar - s(i)
        if(initialSubString <= exist.get ) {
          initialSubString = exist.get +1
            if( globalLength < (i - initialSubString))
              globalLength = i - initialSubString
        }

      }

      uniqueChar = uniqueChar + (s(i) -> i)
      i = i + 1
    }

println(initialSubString)
    if( globalLength < (s.length - initialSubString ))
      globalLength = s.length - initialSubString


    globalLength
  }
}
Solution.lengthOfLongestSubstring("abcabcbb")
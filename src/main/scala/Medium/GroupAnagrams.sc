/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

  Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

  Input: strs = [""]
Output: [[""]]
Example 3:

  Input: strs = ["a"]
Output: [["a"]]


Constraints:

  1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.*/
/*
import scala.collection.mutable
object Solution {
  def groupAnagrams(strs: Array[String]) : List[List[String]] = {
    val letterToWord = generateDictionary(strs)
    var visited = mutable.HashSet[Int]()
    var result = List[List[String]]()
    for(i <- strs.indices) {
      if(!visited.contains(i)){

        var compatible = List.range(0, strs.length)

        for(char <- strs(i)) {
          compatible = compatible.intersect(letterToWord.getOrElse(char, List[Int]())).filter(s => strs(s).count(_ == char) == strs(i).count(_ == char))
        }
        compatible = compatible.filter(x => (strs(x).length == strs(i).length ))
        visited = visited.addAll(compatible)
        result = compatible.map(el => strs(el)) :: result
      }
    }

    result
  }


  def generateDictionary(strs: Array[String]) : Map[Char,  List[Int]] ={
    var letterToWord = Map[Char,  List[Int]]()

    for ( cur <- strs.indices){
      for( el <- strs(cur) )
      {
        val positions: List[Int] = letterToWord.getOrElse(el, List[Int]())
        letterToWord += (el -> (cur :: positions))
      }
    }

    letterToWord
  }
}*/

import scala.collection.mutable
object Solution {
  def groupAnagrams(strs: Array[String]) : List[List[String]] = {
    val letterToWord = generateDictionary(strs)
    var visited = mutable.HashSet[Int]()
    var result = List[List[String]]()
    for(i <- strs.indices) {
      if(!visited.contains(i)){

        var compatible = List.range(0, strs.length)

        for(char <- strs(i)) {
          compatible = compatible.intersect(letterToWord.getOrElse(char, List[Int]())).filter(s => strs(s).count(_ == char) == strs(i).count(_ == char))
        }
        compatible = compatible.filter(x => (strs(x).length == strs(i).length ))
        visited = visited.addAll(compatible)
        result = compatible.map(el => strs(el)) :: result
      }
    }

    result
  }


  def generateDictionary(strs: Array[String]) : Map[Char,  List[Int]] ={
    var letterToWord = Map[Char,  List[Int]]()

    for ( cur <- strs.indices){

      var cur
    }
      for( el <- strs(cur) )
      {
        val positions: List[Int] = letterToWord.getOrElse(el, List[Int]())
        letterToWord += (el -> (cur :: positions))
      }
    }

    letterToWord
  }

Solution.groupAnagrams(Array("dgggg","gdddd"))
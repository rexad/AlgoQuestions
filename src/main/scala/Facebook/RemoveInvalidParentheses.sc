/**
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
* */

object Solution {
  var min: Int= Int.MaxValue
  var listResult = List[String]()
  def removeInvalidParentheses(s: String): List[String] = {
    min= Int.MaxValue
    listResult = List[String]("")
    var result = s
    if (result == null || result.length==0) return List("")
    while(result.length>0 && result(0) == ')') result = result.slice(1, result.length)

    traverse(result, 0, 0,"", 0 ,0)
    listResult
  }

  def traverse(exp: String, left: Int, nbRemoved: Int, correctPar: String, l: Int, r: Int): Unit ={
    if(exp.length == 0 & left == 0 && correctPar.length!= 0 && r ==l) {
      if(nbRemoved < min) {
        listResult = List(correctPar)
        min = nbRemoved
      }
      if(nbRemoved == min && !listResult.contains(correctPar)) listResult= correctPar :: listResult
    }
    if(exp.length != 0) {
      if(exp(0) != '(' && exp(0) != ')') traverse(exp.slice(1, exp.length),left, nbRemoved,correctPar + exp(0),l, r)
      else {
          traverse(exp.slice(1, exp.length),left, nbRemoved+1,correctPar,l, r)
          if(left >= 0 || exp(0) != ')') {
            if(exp(0) == '(') traverse(exp.slice(1, exp.length),left+1, nbRemoved,correctPar + exp(0), l+1, r)
            if(exp(0) == ')' && l> r) traverse(exp.slice(1, exp.length),left-1, nbRemoved,correctPar + exp(0),l, r+1)
          }
      }
    }
  }

}
val s = "()())()"
//s.slice(1, s.length)
Solution.removeInvalidParentheses(s)



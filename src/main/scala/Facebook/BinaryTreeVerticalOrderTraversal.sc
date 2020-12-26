import scala.collection.mutable

/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
* */


  // dDefinition for a binary tree node.
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }
// DFS
object SolutionDfs {
  val mapResult: mutable.Map[Int, List[Int]] = mutable.Map()
  var smallestRank = 0
  def verticalOrder(root: TreeNode): List[List[Int]] = {
    if(root == null) return List[List[Int]]()
    mapResult(smallestRank) =  List(root.value)
    exploreTree(root, 0)
    var result = List[List[Int]]()
    var i = smallestRank
    while(true) {
      if(!mapResult.get(i).isDefined) return result
      result =   result :+ mapResult(i)
      i = i + 1
    }
    return result
  }

  def exploreTree(node: TreeNode, rank: Int): Unit = {
    if(rank < smallestRank) smallestRank = rank

    if(node.left != null) {
      mapResult(rank-1) =  mapResult.get(rank-1).fold(List(node.value))(e =>  node.left.value :: e)
      exploreTree(node.left, rank -1 )
    }
    if(node.right != null) {
      mapResult(rank+1) =  mapResult.get(rank+1).fold(List(node.value))(e =>  node.right.value :: e)
      exploreTree(node.right, rank +1 )
    }

  }
}

//BFS
import scala.collection.mutable

object Solution {

  val mapResult: mutable.Map[Int, List[Int]] = mutable.Map()



  def verticalOrder(root: TreeNode): List[List[Int]] = {
    var smallestRank = 0
    if(root== null) return List[List[Int]]()
    val mapResult: mutable.Map[Int, List[Int]] = mutable.Map()
    var treeQueue= mutable.Queue[(TreeNode, Int)]()
    treeQueue.enqueue((root,0))
    while(treeQueue.nonEmpty) {

      val node = treeQueue.dequeue()
      if(node._2 < smallestRank) smallestRank = node._2
      mapResult(node._2)= mapResult.get(node._2).fold(List(node._1.value))(e =>  e :+ node._1.value)
      if(node._1.left != null) treeQueue.enqueue((node._1.left, node._2-1))
      if(node._1.right != null) treeQueue.enqueue((node._1.right, node._2+1))
    }
    var i = smallestRank
    var result = List[List[Int]]()
    while(true) {
      if(!mapResult.contains(i)) return result
      result =   result :+ mapResult(i)
      i = i + 1
    }
    return result
  }

}
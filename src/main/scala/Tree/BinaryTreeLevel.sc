

//Definition for a binary tree node.
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

object Solution {
  var result = List[List[Int]]()
  def levelOrder(root: TreeNode): List[List[Int]] = {
    result = List[List[Int]]()

    result
  }

  def traverse(node: TreeNode, level: Int):Unit = {
    if(node.left != null)
      traverse(node.left, level+1)

    if(node.right != null)
      traverse(node.right, level+1)


  }
}


//Definition for a binary tree node.
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

object Solution {
  var result: Int = 0
  def maxDepth(root: TreeNode): Int = {
    result = 0
    if(root ==null) return 0
    traverse(root, 1)
    result
  }

  def traverse (node: TreeNode, level: Int): Unit = {
    if(node.left != null)
      traverse(node.left, level+1)

    if(node.right != null)
      traverse(node.right, level+1)

    if(result < level) result = level
  }
}
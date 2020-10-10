
  //Definition for a binary tree node.
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

object Solution {
  var result = List[Int]()
  def inorderTraversal(root: TreeNode): List[Int] = {
    result = List[Int]()
    if(root == null) return List[Int]()


    traverse(root)
    result
  }

  def traverse(node: TreeNode):Unit = {
    if(node.left != null)
      traverse(node.left)
    result = result :+ node.value
    if(node.right != null)
      traverse(node.right)


  }
}

  object Solution2 {
    var result = List[Int]()
    def inorderTraversal(root: TreeNode): List[Int] = {
      result = List[Int]()
      if(root == null) return List[Int]()


      
      result
    }


  }
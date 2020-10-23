/*
*
*
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


*
* */


object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    if(grid.length == 0) return 0
    val nr = grid.length
    val nc = grid(0).length
    var result =0
    for (i <- 0 until nr){
      for (j <- 0 until nc) {
        if(grid(i)(j) == '1') {
          result = result + 1
          dfs(grid, i, j)
        }
      }
    }
    result
  }

  def dfs(grid: Array[Array[Char]], i: Int, j: Int): Unit = {
    if(i>=0 && i <  grid.length && j >= 0 && j < grid(0).length && grid(i)(j) == '1')
    {
      grid(i)(j) = '0'
      dfs(grid, i - 1,j)
      dfs(grid, i + 1,j)
      dfs(grid, i,j - 1)
      dfs(grid, i,j + 1)
    }
  }
}

Solution.numIslands(Array(Array('1', '1', '1', '1', '0'), Array('1', '1', '0', '1', '0') , Array('1', '1', '0', '1', '0') , Array('1', '1', '0', '1', '0')))


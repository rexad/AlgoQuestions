/*
*
* You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.



Example 1:


Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:

Input: rooms = [[-1]]
Output: [[-1]]
Example 3:

Input: rooms = [[2147483647]]
Output: [[2147483647]]
Example 4:

Input: rooms = [[0]]
Output: [[0]]


Constraints:

m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.
*
* */

import scala.collection.mutable.Queue

object Solution {

  val inf = 2147483647
  def wallsAndGates(rooms: Array[Array[Int]]): Unit = {


    val width= rooms(0).length
    val length = rooms.length

    val cache = collection.mutable.Map[(Int, Int), Int]()

    for(i <- 0 until width; j <- 0 until length) {
      if(rooms(i)(j) !=  inf && rooms(i)(j) !=  0 ) {
        rooms(i)(j) = explore(rooms, Queue[(Int, Int)]((i, j)), 0)
      }
    }


  }

  def explore(rooms: Array[Array[Int]], q: Queue[(Int, Int)], count: Int): Int = {

    val current = q.dequeue()
    if(rooms(current._1)(current._2) == 0) return count
    for(i <- root._1 until rooms(0).length; j <- root._2 until rooms.length ; if(rooms(i)(j) != 0)) {
      if(rooms(i)(j) !=  inf) {
        q.enqueue()


      }
    }

  }
}
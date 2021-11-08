

/*
*
*
* You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.



Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:

Input: deadends = ["0000"], target = "8888"
Output: -1


Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only.
*
* */



import scala.collection.mutable
object Solution {
  var min = Int.MaxValue
  var dict: mutable.HashSet[String] = mutable.HashSet[String]()
  var q: mutable.Queue[String] = mutable.Queue[String]()


  def openLock(deadends: Array[String], target: String): Int = {

    q.enqueue("0000")
    q.enqueue("-1")

    var moves = 0
    while(q.nonEmpty) {

      val current = q.dequeue()


      if(current == "-1") {
        moves = moves + 1
        if (q.front == "-1")
          q.enqueue("-1")
      }
      else  if(target.equals(current) ) {
        return moves
      }

        else if(!deadends.contains(current)) {
          for(i <- 0 until 4) {
            for(j <- -1 to 1 by 2) {
              println(current+ " "+ moves)
              val step = (current(i) - '0' + j + 10) % 10
              val newCurrent = current.substring(0, i) + step + current.substring(i + 1)
              if(target.equals(newCurrent) ) {
                return moves
              }
              if(!dict.contains(newCurrent)) {
                q.enqueue(newCurrent)
                dict = dict + current
              }
            }
          }
        }


    }
    -1
  }
}


Solution.openLock(Array("8888"), "0009")





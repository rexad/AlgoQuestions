/*Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

Implementation the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language.



Example 1:

Input
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 3, true, true, true, 4]

Explanation
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4


Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.
*
* */
var array = Array.fill[Int](2)(-1)
println(array(0))

class MyCircularQueue(_k: Int) {
  var array = Array.fill[Int](_k)(-1)
  var head = 0
  var capacity = 0
  def enQueue(value: Int): Boolean = {

    if(isFull()) false
    else {
    array((head + capacity) % _k) = value
    capacity= capacity+ 1
    true
    }
  }

  def deQueue(): Boolean = {
    if(isEmpty()) false
    else {
      array(head) = -1
      head = (head + 1) % _k
      capacity = capacity -1

      true
    }
  }

  def Front(): Int = {
    if(isEmpty()) -1
    else
      array(head)
  }

  def Rear(): Int = {
    if(isEmpty()) -1
    else
      array((head + capacity -1) % _k)
  }

  def isEmpty(): Boolean = {
    if(capacity == 0) true
    else false
  }

  def isFull(): Boolean = {
    if (capacity == _k) true
    else false
  }


}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = new MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
var obj = new MyCircularQueue(6)
obj.enQueue(1)
obj.deQueue()
obj.enQueue(1)
obj.deQueue()
obj.deQueue()

obj
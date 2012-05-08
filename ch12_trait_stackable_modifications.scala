abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

// try it out
val queue = new BasicIntQueue
queue.put(10)
queue.put(20)
println(queue.get)
println(queue.get)

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x)}
}

// try it out
val doubledQueue = new BasicIntQueue with Doubling
doubledQueue put 10
doubledQueue put 20
println(doubledQueue.get)
println(doubledQueue.get)

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1)}
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

// try it out - from the outside to the inside. It is like Incrementing(Filtering())
// --> it is BasicIntQueue with (Incrementing with( Filtering ))
val incrFilterQueue = (new BasicIntQueue with Incrementing with Filtering)
incrFilterQueue.put(-1); incrFilterQueue.put(0); incrFilterQueue.put(1)
println("with Incrementing with Filtering")
println(incrFilterQueue.get)
println(incrFilterQueue.get)

// order of mixin in traits is important!
val filterIncrQueue = (new BasicIntQueue with Filtering with Incrementing)
filterIncrQueue.put(-1); filterIncrQueue.put(0); filterIncrQueue.put(1)
println("with Filtering with Incrementing")
println(filterIncrQueue.get)
println(filterIncrQueue.get)
println(filterIncrQueue.get)

// just another example
val times2plus1Queue = (new BasicIntQueue with Incrementing with Doubling)
times2plus1Queue.put(10)
times2plus1Queue.put(20)
println("with Incrementing with Doubling: should be 21 and 41")
println(times2plus1Queue.get)
println(times2plus1Queue.get)

val plus1times2Queue = (new BasicIntQueue with Doubling with Incrementing)
plus1times2Queue.put(10)
plus1times2Queue.put(20)
println("with Doubling with Incrementing: should be 22 and 42")
println(plus1times2Queue.get)
println(plus1times2Queue.get)

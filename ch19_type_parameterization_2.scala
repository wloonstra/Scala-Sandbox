trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def enqueue[U >: T](x: U): Queue[U]
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new QueueImpl[T](xs.toList, Nil)
  
  private class QueueImpl[+T] (
    private val leading: List[T],
    private val trailing: List[T]
  ) extends Queue[T] {
    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this
        
    def head: T = mirror.leading.head
    
    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }
    
    def enqueue[U >: T](x: U) = new QueueImpl[U](leading, x :: trailing)
  }
}

trait Animal
case class Dog extends Animal
case class Cat extends Animal

val dogs = Queue(new Dog, new Dog)
dogs.enqueue(new Dog)
println(dogs.head)
println(dogs.tail)

// ---

// scala> Queue(new Dog, new Dog)
// res0: Queue[Dog] = Queue$QueueImpl@201b4434

// scala> val dogs = Queue(new Dog, new Dog)
// dogs: Queue[Dog] = Queue$QueueImpl@359172db

// scala> dogs.
// asInstanceOf   enqueue        head           isInstanceOf   tail           toString       

// scala> dogs.isInstanceOf[Queue[Dog]]
// warning: there were 1 unchecked warnings; re-run with -unchecked for details
// res1: Boolean = true

// scala> dogs.isInstanceOf[Queue[Animal]]
// warning: there were 1 unchecked warnings; re-run with -unchecked for details
// res2: Boolean = true

// scala> dogs.isInstanceOf[Queue[Cat]]
// warning: there were 1 unchecked warnings; re-run with -unchecked for details
// res3: Boolean = true

// scala> dogs.enqueue(new Cat)
// res4: Queue[Product with Serializable with Animal] = Queue$QueueImpl@44f6925f

// ---


// so it is a
// Product with Serializable with Animal
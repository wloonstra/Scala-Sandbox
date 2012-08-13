// test single method
// also doesnt work, not enough access to internals

// final case class ::[U] (hd: U, var tl: List[U]) {
//   def head = hd
//   def tail = tl
//   def isEmpty = false
// }
// 
// class Foo[T] {
//   
//   def copy() = println("copy called")
// 
//   private var start: List[T] = Nil
//   private var last0: ::[T] = _
//   private var exported: Boolean = false
//     
//   def += (x: T) {
//     if (exported) copy()
//     if (start.isEmpty) {
//       last0 = new ::(x, Nil)
//       start = last0
//     } else {
//       val last1 = last0
//       last0 = new ::(x, Nil)
//       last1.tl = last0
//     }
//   }
// }

// EXAMPLE is too small
// not all methods are implemented
// below code does not work

// package scala.collection.immutable
// 
// import scala.collection.immutable._
// 
// final class MyListBuffer[T] extends Buffer[T] {
//   private var start: List[T] = Nil
//   private var last0: ::[T] = _
//   private var exported: Boolean = false
//   
//   override def toList: List[T] = {
//     exported = !start.isEmpty
//     start
//   }
//   
//   override def += (x: T) {
//     if (exported) copy()
//     if (start.isEmpty) {
//       last0 = new scala.::(x, Nil)
//       start = last0
//     } else {
//       val last1 = last0
//       last0 = new scala.::(x, Nil)
//       last1.tl = last0
//     }
//   }
// }
// 
// val buf = new MyListBuffer[Int]
// buf += 4
// buf += 8
// 
// println(buf.toList)
// 
// buf += 12
// 
// println(buf.toList)
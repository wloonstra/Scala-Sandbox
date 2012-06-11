// COLLECTIONS

// Lists
// see ch 16

// Arrays

val fiveInts = new Array[Int](5)
printArray(fiveInts)

val fiveToOne = Array(5, 4, 3, 2, 1)
printArray(fiveToOne)

fiveInts(0) = fiveToOne(4)
printArray(fiveInts)

println("Element with index 4: " + fiveInts(4))

private def printArray(array: Array[Int]) = println(array.mkString(", "))

// List buffer

import scala.collection.mutable.ListBuffer

val buf = new ListBuffer[Int]
buf += 1
buf += 2
println(buf)

3 +=: buf
println(buf)

// Array buffer

import scala.collection.mutable.ArrayBuffer

val aBuf = new ArrayBuffer[Int]()

aBuf += 12
aBuf += 15

println(aBuf)

// String is always a StringOps (which is a sequence), since Predef has an implicit conversion from String to StringOps.

def hasUpperCase(s: String) = s.exists(_.isUpper)
println("hasUppserCase Wiggert Loonstra: " + hasUpperCase("Wiggert Loonstra"))
println("hasUpperCase bla bla: " + hasUpperCase("bla bla"))
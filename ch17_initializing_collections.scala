// to initialize with type, make it with type parameter

import scala.collection.mutable

val stuff = mutable.Set[Any](1, 2)
stuff += "hello"
println(stuff)

// from a list to a tree set

val colors = List("blue", "red", "yellow", "blue", "green")

import scala.collection.immutable.TreeSet

// val treeSet = TreeSet(colors) //doesn't work, no constructor

val treeSet = TreeSet[String]() ++ colors
val treeSet2 = TreeSet.empty[String] ++ colors // another way of creating empty set
println(treeSet)
println(treeSet2)

// to list or array

println(treeSet.toList) // order is kept as in treeSet, so it's sorted now
println(treeSet.toArray.mkString("Array(", ", ", ")"))


// ++ and ++=

// on Mutable
// ++ only ads it and then it returns a new collection with the added list of elements
// ++= adds to that existing list

// on Immutable
// ++ only ads it and then it returns a new collection with the added list of elements
// ++= is converted to a = a ++ b --> only works for var if its immutable

println(treeSet) // immutable

println("on single element")

val mutaSet = mutable.Set.empty ++ treeSet
println(mutaSet + "orange")
println(mutaSet)
mutaSet += "orange"
println(mutaSet)
mutaSet -= "orange"

var immutaSet = Set.empty ++ mutaSet // need to be a var for reassignment later
println(immutaSet)
println(immutaSet + "orange")
println(immutaSet)
immutaSet += "orange"
println(immutaSet)

println("on list")

// list
val mutaSet2 = mutable.Set.empty ++ treeSet
println(mutaSet2 ++ List("orange"))
println(mutaSet2)
mutaSet2 ++= List("orange")
println(mutaSet2)
mutaSet2 --= List("orange")

var immutaSet2 = Set.empty ++ mutaSet2 // need to be a var for reassignment later
println(immutaSet2)
println(immutaSet2 ++ List("orange"))
println(immutaSet2)
immutaSet2 ++= List("orange")
println(immutaSet2)







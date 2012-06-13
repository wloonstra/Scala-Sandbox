// Map

import scala.collection.mutable

val map = mutable.Map.empty[String, Int]
map("hello") = 1
map("there") = 2

println(map)
println(map("hello"))

def countWords(text: String) = {
  val counts = mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ ,!.]+")) {
    val word = rawWord.toLowerCase
    val oldCount = 
      if (counts.contains(word)) counts(word)
      else 0
    counts += (word -> (oldCount + 1))
  }
  counts
}

println(countWords("See Spot run! Run, Spot. Run!"))

// methods on Map

val nums = Map("i" -> 1, "ii" -> 2)
p(nums)
p(nums + ("vi" -> 6))
p(nums - "ii")
p(nums ++ List("iii" -> 3, "v" -> 5))
p(nums -- List("i", "ii"))
p(nums.size)
p(nums.contains("ii"))
p(nums("ii"))
p(nums.keys)
p(nums.keySet)
p(nums.values)
p(nums.isEmpty)

val words = mutable.Map.empty[String, Int]
words += ("one" -> 1)
p(words)

words -= ("one")
p(words)

words ++= List("one" -> 1, "two" -> 2, "three" -> 3)
p(words)

words --= List("one", "two")
p(words)

// you can create mutable map same way, as long as you have correct import
val bla = mutable.Map("bla" -> "foo")
p(bla)

// TREEMAP

import scala.collection.immutable.TreeMap
var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x') // remember: this is a var. So it is reassigned on +=
p(tm)
tm += (2 -> 'x')
p(tm)

def p(any: Any) = println(any.toString)
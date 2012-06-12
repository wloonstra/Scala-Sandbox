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
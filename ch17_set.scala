// Sets

import scala.collection.mutable

val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")
val words = mutable.Set.empty[String]

for (word <- wordsArray)
  words += word.toLowerCase
  
println(words)

println("Set and number operations")
val nums = Set(1, 2, 3)
println(nums + 5)
println(nums - 3)
println(nums ++ List(5, 6))
println(nums -- List(1, 2))
println(nums & Set(1, 3, 5, 7)) //intersection!

println("Set and word operations")
val testWords = mutable.Set.empty[String]
testWords += "the"
println(testWords)
testWords -= "the"
println(testWords)

testWords ++= List("do", "re", "mi")
println(testWords)
testWords --= List("do", "re")
println(testWords)

testWords.clear
println(testWords)
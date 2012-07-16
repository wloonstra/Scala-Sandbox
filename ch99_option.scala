// OPTIONS, MAP AND FLATMAP

val p: Option[String] = Some("3")
val q: Option[String] = None

println(p.map(string => string.toInt))
//              "3"          3        // resulting in Some(3)

println(q.map(string => string.toInt))
//             None                  // resulting in None

println(p.flatMap(string => {
  val intValue = string.toInt
  if (intValue > 5) Some(intValue) else None
}))
//      "3"
//            transformed to int
//            check > 5
//                             resulting in None

val r = Some("6")
println(r.flatMap(string => {
  val intValue = string.toInt
  if (intValue > 5) Some(intValue) else None
}))
//       "6"
//              transformed to int
//              check > 5
//                             resulting in Some(6)

println(q.flatMap(string => Some("hallo")))  // resulting in None

// Applied to List
// Option is treated as a List in the sense that flatMap on a List[Option[A]] returns the Some[A] only.

val myList: List[Option[Int]] = List(Some(4), Some(5), None, Some(6))
println(myList.map(i => i.map(_ * 2)))     // List(Some(8), Some(10), None, Some(12))
println(myList.flatMap(i => i.map(_ * 2))) // List(8, 10, 12)
println(myList.flatten)                    // List(4, 5, 6)
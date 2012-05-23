val second2: List[Int] => Int = {
  case x :: y :: _ => y
}

val second: PartialFunction[List[Int], Int] = {
  case x :: y :: _ => y
}

println(second2(List(5, 6, 7)))
println(second(List(5, 6, 7)))
// println(second(List())) // MatchError (runtime)
println(second.isDefinedAt(List(5, 6, 7)))
println(second.isDefinedAt(List()))
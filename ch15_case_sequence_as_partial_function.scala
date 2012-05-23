// this is from the book
val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

// this is what I would have written
val withDefault2 = (option: Option[Int]) => {
  option match {
    case Some(x) => x
    case None => -1
  }
}

// is withDefault shorter form of withDefault?
// or is it technically something else??

println(withDefault(Some(10)))
println(withDefault(None))
println(withDefault2(Some(10)))
println(withDefault2(None))
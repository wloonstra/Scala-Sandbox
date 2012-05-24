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

// it is just a shortcut.
// for withDefault2 you could write:
// val withDefault2: Option[Int] => Int = (option: Option[Int]) => {
//   blabla
//}
// then you do have the type in the value definition. Since the method itself
// defines more clearly that option is of type Option[Int] the complete type definition
// after withDefault2: can be omitted. The compiler understand.
// In case of withDefault: it doens't know what type of Some(x) is, some it's needed tot tell
// val withDefault: Option[Int] => Int

println(withDefault(Some(10)))
println(withDefault(None))
println(withDefault2(Some(10)))
println(withDefault2(None))
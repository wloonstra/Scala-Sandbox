val firstArg = if (args.length > 0) args(0) else ""

// This version is very verbose: the println is on every line.
// More important: the match has side effects!!
def match1 = {
  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }
}

// In this version the match doesnt have side effects. It's used to assign a value.
// This means match/case returns a value!
// Then the println is applied to the result. This is more functional programming style.
def match2 = {
  val friend = 
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
  println(friend)
}

match1
match2
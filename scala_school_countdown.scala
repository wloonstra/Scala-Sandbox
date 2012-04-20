def countdown(n: Int, messages: List[String] = List()): List[String] = {
  n match {
    case 0 => messages.reverse
    case _ => countdown(n - 1, n.toString :: messages)
  }
}

def print(list: List[String]) = {
  println(list.mkString("\n"))
}

print(countdown(10))



def countdown2(n: Int): List[Int] = {
  n match {
    case 0 => 0 :: Nil
    case _ => n :: countdown2(n - 1)
  }
}
println(countdown2(10).mkString("\n"))
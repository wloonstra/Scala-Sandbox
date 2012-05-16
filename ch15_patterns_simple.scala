def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case _ => "something else"
}

println(describe(5))
println(describe(true))
println(describe("hello"))
println(describe(List()))
println(describe(List(1,2,3)))

println("--------")

// uppercased: constant
// lowercased: variable

import math.{E, Pi}

def mathMatch(x: Any) = x match {
  case Pi => "strange math? Pi = " + Pi
  case _ => "OK"
}
println(mathMatch(E))

def mathMatchVariable(x: Any) = {
  val pi = math.Pi
  x match {
    case pi => "strange math? Pi = " + pi
    // case _ => "OK" // <-- this does not compile. "Unreachable code". It shows already that pi (lowercased) matches everything.
  }
}

println(mathMatchVariable(E))
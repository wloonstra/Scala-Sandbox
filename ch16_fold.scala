// fold left
// (z /: List(a, b, c)) (op)   equals   op(op(op(z, a), b), c)
// z           startvalue
// List(a,b,c) to apply fold left to
// op          binary operation

// it's fold LEFT, so starting from a.

// fold right
// (List(a, b, c) :\ z) (op)   equals   op(a, op(b, op(c, z)))

val words = List("one", "two", "three")

println("one string fold left: " + ( ("" /: words) (_ + " " + _)  ))
println("one string fold left: " + ( (words.head /: words.tail) (_ + " " + _)  ))

println("one string fold right: " + ( (words :\ "") (_ + " " + _)  ))
println("one string fold left: " + ( (words.init :\ words.last) (_ + " " + _)  ))

println("character size fold left: " + (  (0 /: words) ((result: Int, element: String) => result + element.length)  ))
println("character size fold left: " + (  (0 /: words) (_ + _.length)  ))
println("character size fold right: " + (  (words :\ 0) (_.length + _)  ))

println("one string fold left: " + (  words.tail.foldLeft(words.head) ((result: String, element: String) => result + " " + element))  )

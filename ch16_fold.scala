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
println("one string fold right: " + ( (words :\ "") (_ + " " + _)  ))

println("one string fold left: " + ( (words.head /: words.tail) (_ + " " + _)  ))
println("one string fold right: " + ( (words.init :\ words.last) (_ + " " + _)  ))

println("character size fold left: " + (  (0 /: words) ((result: Int, element: String) => result + element.length)  ))
println("character size fold left: " + (  (0 /: words) (_ + _.length)  ))
println("character size fold right: " + (  (words :\ 0) ((element: String, result: Int) => element.length + result)  ))
println("character size fold right: " + (  (words :\ 0) (_.length + _)  ))

println("one string fold left: " + (  words.tail.foldLeft(words.head) ((result: String, element: String) => result + " " + element)  ))
println("one string fold left: " + (  words.tail.foldLeft(words.head) (_ + " " + _)  ))
println("one string fold right: " + (  words.init.foldRight(words.last) ((result: String, element: String) => result + " " + element)  ))
println("one string fold right: " + (  words.init.foldRight(words.last) (_ + " " + _)  ))

println("character size fold left: " + (  words.foldLeft(0) ((result: Int, element: String) => result + element.length) ))
println("character size fold left: " + (  words.foldLeft(0) (_ + _.length)  ))
println("character size fold right: " + (  words.foldRight(0) ((element: String, result: Int) => element.length + result)  ))
println("character size fold right: " + (  words.foldRight(0) (_.length + _)  ))

// fold left: your start value is at the left side. So that is the first type (startvalue type, listvalue type)
// fold right: your start value is at the right side. So that is the second type (listvalue type, startvalue type) 

// reverse a list using foldLeft

def reverseLeft[T](xs: List[T]) = (List[T]() /: xs) {(ys, y) => y :: ys}
println(reverseLeft(List(1, 2, 3, 4, 5)))
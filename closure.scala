def p (p: Any) { println(p) }

// Closed term functions, all variables are bound - living in scope of function
val f1 = (x: Int) => x + 1
p (f1(1))
val f2 = (_: Int) + 1
p (f2(1))

// Open term function
var more = 1
val f3 = (x: Int) => x + more // at compile time it's 'closed' when free variables are assigned
p (f3(1))
more = 2
p (f3(1))

// someNumbers
val someNumbers = List(-11, -10, -5, 0 , 5, 10)

var sum = 0
someNumbers.foreach(sum += _)
p (sum)

// WITH CLOSURE

def makeIncreaser(more: Int) = (x: Int) => x + more
val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)

p (inc1(10))
p (inc9999(10))

// WITH PARTIALLY APPLIED FUNCTIONS

def increase(x: Int, y: Int) = x + y
val incz1 = increase(1, _: Int)
val incz9999 = increase(9999, _: Int)

p (incz1(10))
p (incz9999(10))

val more2 = 10
val increase2 = (x: Int) => x + more2


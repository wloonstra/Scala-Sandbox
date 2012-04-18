// helper
def p(p: Any) { println(p) }

// data
val someNumbers = List(-11, -10, -5, 0, 5, 10)

// smaller functions
p(someNumbers.filter((x: Int) => x > 0))
p(someNumbers.filter((x) => x > 0))
p(someNumbers.filter(x => x > 0))
p(someNumbers.filter(_ > 0))

// placeholder syntax
val f1 = (_: Int) + (_: Int) // function object! its assigned to val, not a def
p( f1(4, 5) )

def add(x: Int, y: Int) = x + y
val f2 = add _ // partially applied
p (f2(4, 5) )

someNumbers.foreach(println _) // partially applied
someNumbers.foreach(println) // can leave out _ where function is required

def sum(a: Int, b: Int, c: Int) = a + b + c
val part3 = sum _
val part2 = sum(1, _: Int, _: Int) // you need to specify the type!!
            // sum(1, _, _) will not work

p( part3(1, 2, 3))
p( part2(2, 3))
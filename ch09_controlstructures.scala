def twice(op: Double => Double, x: Double) = op(op(x))

println(twice((x: Double) => x + 1, 5))
println(twice(_ + 1, 5))

// when splitting the argument list into multiple single arguments, you can call it with curly braces
// curly braces works on single argument only
def twice2(x: Double)(op: Double => Double) = op(op(x))

println(twice2(5) {
  x => x + 1
})

// --

var assertionsEnabled = true

def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError

myAssert(() => 5 > 3) // parentheses needed, empty parameter list
// myAssert(5 > 3) // doesn't compile! it expects a function with empty parameter list

def byNameAssert(predicate: => Boolean) = 
  if (assertionsEnabled && !predicate) // NO parenthesis () for predicate. It's defined without!
    throw new AssertionError
    
byNameAssert(5 > 3) // illegal: byNameAssert(() => 5 > 3)

def boolAssert(predicate: Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError
    
boolAssert(5 > 3) // Different from byNameAssert(5 > 3).
// In boolAssert 5 > 3 is evaluated before the function boolAssert runs.
// In byNameAssert is passed as a function and evaluated the moment the function byNameAssert call it.

// To illustrate:
assertionsEnabled = false

byNameAssert(3 / 0 == 0)
// boolAssert(3 / 0 == 0) // fails!

class Foo(val name: String)
class Bar(val name: String)
  
object Foo {
  implicit def toBar(foo: Foo) = new Bar("it was a foo, now it's a bar " + foo.name)
  implicit def fromBar(bar: Bar) = new Foo("it was a bar, now it's a foo " + bar.name)
}

def printBar(bar: Bar) = println(bar.name)
def printFoo(foo: Foo) = println(foo.name)

printBar(new Bar("myBar")) // myBar
printBar(new Foo("myFoo")) // it was a foo, now it's a bar myFoo - conversion done on source
printFoo(new Bar("myBar")) // it was a bar, now it's a foo myBar - conversion done on target
printFoo(new Foo("myFoo")) // myFoo
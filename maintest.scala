class Foo {
  def print() = println("Hello World")
  def apply(name: String) = println("Hello " + name)
}

object MyRunner {
  def main(args: Array[String]) {
    new Foo()(args(0))
  }
}

object MyRunner2 extends App {
  new Foo()("Wiggert")
}

object Demo {
  val x = { println("initializing x"); "done" }
}

println(Demo)
println("something in between")
println(Demo.x)

object LazyDemo {
  lazy val x = { println("initializing x"); "done" }
}

println("---")
println(LazyDemo)
println("something in between")
println(LazyDemo.x)
def echo(args: String*) = for (arg <- args) println(arg)

echo()
println("---")
echo("hello")
println("---")
echo("hello", "world")
println("---")

val arr = Array("one", "two", "three")
echo(arr: _*)

println("---")

def speed(distance: Float, time: Float): Float = distance / time

println(speed(100, 10))
println(speed(distance = 100, time = 10))
println(speed(time = 10, distance = 100))

println("---")

def printTime(out: java.io.PrintStream = Console.out) = out.println("time= " + System.currentTimeMillis())

printTime()
printTime(out = Console.err)

def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) = out.println("time= " + System.currentTimeMillis() / divisor)
printTime2()
printTime2(out = Console.err)
printTime2(out = Console.err, divisor = 1000)
printTime2(divisor = 1000, out = Console.err)
printTime2(Console.err)
// printTime2(1000) // doesnt work



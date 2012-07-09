trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  override def toString = numer + "/" + denom
}

val x = 2
// the following doesn't compile!
// produces: java.lang.IllegalArgumentException: requirement failed

// new RationalTrait {
//   val numerArg = 1 * x
//   val denomArg = 2 * x
// }

// At creation of trait, numerArg and denomArg are not set yet. See LAZY VALS below.

// PRE-INITIALIZED FIELDS
// 1. attempt to fix
val a = new {
  val numerArg = 1 * x
  val denomArg = 2 * x
} with RationalTrait
println(a)

// 2. attempt to fix

object OneHalf extends {
  val numerArg = 1 * x
  val denomArg = 2 * x
} with RationalTrait
println(OneHalf)

// LAZY VALS
// Compiler figures out when instantiation of field is required.
val b = new RationalTrait {
  lazy val numerArg = 1 * x
  lazy val denomArg = 2 * x
}
println(b)
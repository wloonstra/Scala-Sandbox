object ExponentCalculator {

  def calcExponent(base: Int, exponent: Int): Int = {
    println("... %d ^ %d".format(base, exponent))
    exponent match {
      case exp if exp > 0 && exp % 2 == 0 => calcExponent(base, exp / 2) * calcExponent(base, exp / 2)
      case exp if exp > 0 && exp % 2 == 1 => base * calcExponent(base, exp - 1)
      case exp if exp == 0 => 1
      case exp if exp < 0 => 1 / calcExponent(base, -exp)
      case _ => 0
    }
  }
}

println("2 ^ 4")
println("2 ^ 4: " + ExponentCalculator.calcExponent(2, 4))
println("2 ^ 3")
println("2 ^ 3: " + ExponentCalculator.calcExponent(2, 3))
println("2 ^ 0")
println("2 ^ 0: " + ExponentCalculator.calcExponent(2, 0))
println("2 ^ -1")
println("2 ^ -1: " + ExponentCalculator.calcExponent(2, -1))

class Rational(n: Int, d: Int) {
	
	require(d != 0)
	
	private val g = gcd(n.abs, d.abs)	
	val numer = n / g
	val denom = d / g
	
	def this(n: Int) = this(n, 1)
	
	def + (that: Rational): Rational =
		new Rational(numer * that.denom + that.numer * denom, 
								 denom * that.denom)
								
	def + (i: Int): Rational = 
		new Rational(numer + i * denom, denom)
	
	def - (that: Rational): Rational =
		new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
		
	def - (i: Int): Rational = 
		new Rational(numer - i * denom, denom)

	def * (that: Rational): Rational =
		new Rational(numer * that.numer, denom * that.denom)
		
	def * (i: Int): Rational =
		new Rational(numer * i, denom)
		
	def / (that: Rational): Rational =
		new Rational(numer * that.denom, denom * that.numer)
	
	def / (i: Int): Rational =
		new Rational(numer, denom * i)
	
	def lessThan(that: Rational) = this.numer * that.denom < that.numer * this.denom
	
	def max(that: Rational) = if (this.lessThan(that)) that else this
	
	override def toString = numer + "/" + denom
	
	private def gcd(a: Int, b: Int): Int = 
		if (b == 0) a else gcd(b, a % b)
}


val oneHalf = new Rational(1, 2)
val twoThirds = new Rational(2, 3)
println(oneHalf + " + " + twoThirds + " = " + (oneHalf + twoThirds))
println("Maximum " + (oneHalf max twoThirds))

println("Integer: " + new Rational(3))

println("9 % 12: " + 9 % 12)
println("12 % 9: " + 12 % 9)

val x = oneHalf
val y = twoThirds

println("66/42: " + new Rational(66, 42))

println(x + x * y)
println((x + x) * y)
println(x + (x * y))

implicit def intToRational(x: Int) = new Rational(x) // name not important!

println("oneHalf * 2 = " + (oneHalf * 2))
println("2 * oneHalf = " + (2 * oneHalf))
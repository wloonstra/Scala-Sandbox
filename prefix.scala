class Foo {
	def unary_+ = { println("+") }
	def unary_- = { println("-") }
	def unary_! = { println("!") }
	def unary_~ = { println("~") }
}

object RunPrefix {
	def main(args: Array[String]): Unit = {
		val f = new Foo
		+f
		-f
		!f
		~f
	}
}
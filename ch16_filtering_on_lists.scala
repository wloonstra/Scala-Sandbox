val numbers = List(1, 2, 3, 4, 5)

p("Numbers: " + numbers)
p("""filter (_ % 2 == 0) """ + (numbers filter (_ % 2 == 0)))
p("""xs partition p  equals  (xs filter p, xs filter (!p(_)))""")
p("""partition (_ % 2 == 0) """ + (numbers partition (_ % 2 == 0)))
p("""find returns first found element (as an Option[T])""")
p("""find (_ % 2 == 0) """ + (numbers find (_ % 2 == 0)))
p("""find (_ > 8) """ + (numbers find (_ > 8)))

def p(any: Any) = println(any.toString)
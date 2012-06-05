val numbers = List(1, 2, 3, 4, 5)

p("Numbers: " + numbers)
p("""filter (_ % 2 == 0) """ + (numbers filter (_ % 2 == 0)))
p("""xs partition p  equals  (xs filter p, xs filter (!p(_)))""")
p("""partition (_ % 2 == 0) """ + (numbers partition (_ % 2 == 0)))
p("""find returns first found element (as an Option[T])""")
p("""find (_ % 2 == 0) """ + (numbers find (_ % 2 == 0)))
p("""find (_ > 8) """ + (numbers find (_ > 8)))

// takeWhile: takes the longest prefix of list xs such that every element in the prefix satisfies p
p("""takeWhile (_ < 3) """ + (numbers takeWhile (_ < 3)))
// dropWhile: removes the longest prefix of list xs such that every element in the prefix satisfies p
p("""dropWhile (_ < 3) """ + (numbers dropWhile (_ < 3)))

p("xs span p  equals  (xs takeWhile p, xs dropWhile p)")
p("""span (_ < 3) """ + (numbers span (_ < 3)))

// forall and exists
// forall: every element satisfies predicate
// exists: at least one element satisfies predicate
def hasZeroRow(m: List[List[Int]]) = m exists (row => row forall (_ == 0))

val identityMatrix = List(
  List(1, 0, 0),
  List(0, 1, 0),
  List(0, 0, 1)
)

val nulMatrix = List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 0)
  )


p("identity has zero row: " + hasZeroRow(identityMatrix))
p("nul matrix has zero row: " + hasZeroRow(nulMatrix))

def p(any: Any) = println(any.toString)
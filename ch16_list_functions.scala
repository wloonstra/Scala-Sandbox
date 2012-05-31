val l = List('a', 'b', 'c', 'd', 'e')

p("list: " + l)

pLine
p("head: " + l.head)
p("tail: " + l.tail)
p("init: " + l.init)
p("last: " + l.last)

pLine
p("reverse: " + l.reverse)

pLine
// take returns a list with the first n elements
p("take 2: " + l.take(2))
// drop returns a list without the first n elements
p("drop 2: " + l.drop(2))

pLine
p("splitAt(n) = (take(n), drop(n))")
p("splitAt 2: " + l.splitAt(2))

pLine
p("apply(n) = (drop(n)).head")
p("apply 2: " + l.apply(2))
p("drop(2).head: " + l.drop(2).head)

pLine
val lOfL = List(List('a', 'b'), List('c'), List(), List('d', 'e'))
p("lOfL: " + lOfL)
p("flatten: " + lOfL.flatten)

pLine
val zipped = l.indices zip l
p("zip with indices: " + zipped)
p("zip with index: " + l.zipWithIndex)
p("unzip: " + zipped.unzip)

pLine
p("mkString [ , ]: " + l.mkString("[",",","]"))




def p(any: Any) = println(any.toString)
def pLine = p("=========================")
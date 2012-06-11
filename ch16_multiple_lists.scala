// zipped on tuples of lists combines first elements, second elements, and so on.

println((List(10, 20), List(3, 4, 5)).zipped.map(_ * _))
println((List("abc", "de"), List(3, 2)).zipped.forall(_.length == _))
println((List("abc", "de"), List(3, 2)).zipped.exists(_.length != _))
val result = List.range(1, 5) flatMap (
  i => List.range(1, i) map (j => (i, j))
)

println(result)

// with for expression
val resultWithFor = for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)

println(resultWithFor)

// This produces empty list
println("Empty list: List.range(1,1). Indeed: " + List.range(1,1))
// range

println(List.range(1, 5))
println(List.range(1, 9, 2))
println(List.range(1, 10, 2))
println(List.range(9, 1, -3))
println(List.range(1, 9, -3))

// fill

println(List.fill(4)("hello"))
println(List.fill(4)(2))
println(List.fill(4, 3)(0))

// tabulate
// like fill, but with function to define contents

println(List.tabulate(10)(n => n * n))
println(List.tabulate(5, 5)(_ * _))
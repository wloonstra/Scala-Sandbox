def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
    case (Nil, _) => ys
    case (_, Nil) => xs
    case (x :: xs1, y :: ys1) =>
      if (less(x, y)) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
  }
  
  // println("To Sort: " + xs)
  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
    
}

val list = List(5, 3, 7, 9, 5, 2, 1, 6, 43, 3, 8, 9, 0, 4, 6, 45, 787, 3, 2334, 6, 90)
println(
  msort((x: Int, y: Int) => x < y)(list)
)

// It's a nice algorithm, but I want to understand it better. Maybe write it down step by step.
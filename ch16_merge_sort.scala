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



// With this I try out the merge function on its own. What does it do?
// It merges two list and takes at each time the smallest number from the beginning of the list, first.
// This means: the lists that are merged need to be sorted on their own!
def merge2(less: (Int, Int) => Boolean)(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
  case (Nil, _) => ys
  case (_, Nil) => xs
  case (x :: xs1, y :: ys1) =>
    if (less(x, y)) x :: merge2(less)(xs1, ys)
    else y :: merge2(less)(xs, ys1)
}

  println("example: " + merge2((x: Int, y: Int) => (x < y))(List(8, 4), List(9, 1)))
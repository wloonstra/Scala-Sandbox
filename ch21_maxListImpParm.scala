def maxListImpParm[T](elements: List[T])(implicit orderer: T => Ordered[T]): T =
  elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest => 
      val maxRest = maxListImpParm(rest)(orderer)
      if (orderer(x) > maxRest) x
      else maxRest
  }
  
println(maxListImpParm(List(1, 5, 10, 3)))
println(maxListImpParm(List(1.5, 5.2, 10.7, 3.14159)))
println(maxListImpParm(List("one", "two", "three")))

// BUT, you can leave out the orderer parameter completely.
// it is inserted implicitly everywhere you need it

def maxListImpParm2[T](elements: List[T])(implicit orderer: T => Ordered[T]): T =
  elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest => 
      val maxRest = maxListImpParm(rest)
      if (x > maxRest) x
      else maxRest
  }
  
println(maxListImpParm2(List(1, 5, 10, 3)))
println(maxListImpParm2(List(1.5, 5.2, 10.7, 3.14159)))
println(maxListImpParm2(List("one", "two", "three")))

// With VIEW BOUNDS you even do not have to specify second argument list.
// View Bound: I can use T so long as T can be treated as an Ordered[T]
// UpperBound is: so long that T _is_ an Ordered[T] (notated as T <: Ordered[T])

def maxListImpParm3[T <% Ordered[T]](elements: List[T]): T =
  elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest => 
      val maxRest = maxListImpParm(rest)
      if (x > maxRest) x
      else maxRest
  }
  
println(maxListImpParm3(List(1, 5, 10, 3)))
println(maxListImpParm3(List(1.5, 5.2, 10.7, 3.14159)))
println(maxListImpParm3(List("one", "two", "three")))
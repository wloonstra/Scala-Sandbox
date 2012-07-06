abstract class Fruit {
  val v: String
  def m: String
}

abstract class Apple extends Fruit {
  val v: String
  val m: String
}

abstract class BadApple extends Fruit {
  //def v: String // ERROR
  def m: String
}

// what about concrete classes?

class MyApple extends Fruit {
  val v: String = "hoi"
  val m: String = "hoi"
}

class MyBadApple extends Fruit {
  // def v: String = "hoi"
  // it really needs to be:
  val v: String = "hoi"
  def m: String = "hoi"
}
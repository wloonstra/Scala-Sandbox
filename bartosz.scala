object X extends Y {
  val bla: String
}

trait Y {
  this:{val dataSource:DS} =>
  def foo = bla  + " world"
  
}

AppContext extends {
  val resourceFiles = List(xxxx)
} with ServiceFConfig with BoneCpData with Sequret {
  
}

abstract class Operation
case class Plus
case class Multiplier

with Plus with Multipl
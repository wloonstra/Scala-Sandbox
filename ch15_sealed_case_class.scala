sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object TryItOuy {
  def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
}

// This gives a warning:
// ch15_sealed_case_class.scala:8: warning: match is not exhaustive!
// missing combination          BinOp
// missing combination           UnOp
// 
//   def describe(e: Expr): String = e match {
//                                   ^
// one warning found

object TryItOuyWithoutWarning {
  def describe(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
}

// This is warning free
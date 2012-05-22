val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}

p(show(capitals get "Japan"))
p(show(capitals get "France"))
p(show(capitals get "North Pole"))

def p(line: String) = println(line)
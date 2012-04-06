import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg +": " + calculate(arg))
  }
}

object FallWinterSpringSummer extends App {
  for (season <- List("Fall", "Winter", "Spring", "Summer"))
    println(season +": "+ calculate(season))
}

val data = List("file1.txt", "-file2.scala", "file3.java", "-file4.scala", "file5.scala")

object Imperative {
  def find() = {
    var i = -1
    var foundIt = false
  
    while (i < data.length && !foundIt) {
      i = i + 1 // small difference compared to book. put it in front and start with -1 to avoid counting +1 when position was already found!
      if (!data(i).startsWith("-")) {
        if (data(i).endsWith(".scala"))
          foundIt = true
      }
    }
    i
  }
}

object Functional {
  def searchFrom(i: Int): Int =
    if (i >= data.length) -1
    else if (data(i).startsWith("-")) searchFrom(i + 1)
    else if (data(i).endsWith(".scala")) i
    else searchFrom(i + 1)
  
}

println(Imperative.find)
println(Functional.searchFrom(0))

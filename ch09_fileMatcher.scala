private def filesHere = (new java.io.File(".")).listFiles

object FileMatcher {
  
  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file
  
  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file
      
  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file
}

println("--- Ending .class")
FileMatcher.filesEnding(".class").foreach(println)

println("--- Contains ch08")
FileMatcher.filesContaining("ch08").foreach(println)

println("--- Matching .*[0-9]+.*")
FileMatcher.filesRegex(""".*[0-9]+.*""").foreach(println)

object FileMatcher2 { // with passed in functions
  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }
  
  def filesEnding(query: String) =
    filesMatching(query, (fileName: String, query: String) => fileName.endsWith(query)) // complete written down

  def filesContaining(query: String) =
    filesMatching(query, _.contains(_)) // short version...!

  def filesRegex(query: String) =
    filesMatching(query, _.matches(_))
}

println("--- Ending .class")
FileMatcher2.filesEnding(".class").foreach(println)

println("--- Contains ch08")
FileMatcher2.filesContaining("ch08").foreach(println)

println("--- Matching .*[0-9]+.*")
FileMatcher2.filesRegex(""".*[0-9]+.*""").foreach(println)


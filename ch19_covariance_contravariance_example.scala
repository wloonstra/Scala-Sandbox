class Publication(val title: String)
class Book(title: String) extends Publication(title)

object Library {
  val books: Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Walden")
    )
    
  def printBookList(info: Book => AnyRef) {              // --> Book => AnyRef
    for (book <- books) println(info(book))
  }
}

object Customer {
  def runIt {
    def getTitle(p: Publication): String = p.title         // --> Publication => String
    Library.printBookList(getTitle)
  }
}

Customer.runIt

// Book => AnyRef
// Publication is used in Customer
// Requires less: the body of getTitle is only allowed to use functions from what's declared in Publication
// -- contravariant

// Provides more: it returns AnyRef.
// if AnyRef already has a toString method, than eacht subclass for sure as well.
// -- covariant
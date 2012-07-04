class Publication(val title: String)
class Book(title: String) extends Publication(title)
class SubBook(title: String) extends Book(title)

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
    def getTitle(p: Publication): String = p.title       // --> Publication => String
//    def getTitle(sb: SubBook): String = sb.title         // --> SubBook => String  // doesn't compile.
    Library.printBookList(getTitle)
  }
}

Customer.runIt

// Book => AnyRef
// Publication is used in Customer
// Requires less: the body of getTitle is only allowed to use functions from what's declared in Publication
// and all that is used in Publication is available in Book as well
// The other way around, my own example SubBook, doesn't work. Here you could use all methods inside subbook,
// but those are not garanteed to be available on Book itself!
//
// The methods on Publication will be executed on the _Book_'s in Library!!
// -- contravariant

// Provides more: it returns AnyRef.
// if AnyRef already has a toString method, than eacht subclass for sure as well.
// -- covariant
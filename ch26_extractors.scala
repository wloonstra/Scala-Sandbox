object Email {
  def apply(user: String, domain: String) = user + "@" + domain
  
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

// one can define Email as:
//   object Email extends ((String, String) => String)
// then it can be passed to functions where a function (String, String) => String is required
  

def mailString(str: String) = str match {
  case Email(user, domain) => "This is the email: " + user + " AT " + domain
  case _ => "Not Found"
}

println(mailString("wiggert@loonstra.nl"))
println(mailString("bladiebla"))
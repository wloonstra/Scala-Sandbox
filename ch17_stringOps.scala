// String is always a StringOps (which is a sequence), since Predef has an implicit conversion from String to StringOps.

def hasUpperCase(s: String) = s.exists(_.isUpper)
println("hasUppserCase Wiggert Loonstra: " + hasUpperCase("Wiggert Loonstra"))
println("hasUpperCase bla bla: " + hasUpperCase("bla bla"))
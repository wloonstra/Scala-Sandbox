class Bar {
  
  def update(position: Int, value: String) {
    println("position %d, value %s".format(position, value))
  }
  
}

val bar = new Bar
bar.update(0, "bla")
bar(1) = "no!"
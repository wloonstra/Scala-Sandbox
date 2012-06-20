class Time {
  private[this] var h = 12
  var minute = 0
  
  def hour: Int = h
  def hour_=(x: Int) {
    println("setting h")
    h = x
  }
}

val time = new Time
println(time.hour)
println(time.minute)

time.hour = 13
time.hour_=(13)

println(time.hour)
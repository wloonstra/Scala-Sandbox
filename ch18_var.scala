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

class Thermometer {
  var celsius: Float = _
  
  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= (f: Float) {
    celsius = (f - 32) * 5 / 9
  }
  override def toString = fahrenheit + "F/" + celsius + "C"
}

val t = new Thermometer
t.celsius = 100
println(t)
t.fahrenheit = -40
println(t)
t.fahrenheit = 93
println(t)

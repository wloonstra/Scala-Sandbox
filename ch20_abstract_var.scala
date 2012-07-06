trait AbstractTime {
  var hour: Int
  var minute: Int
}

trait AbstractTime2 {
  def hour: Int
  def hour_=(x: Int)
  def minute: Int
  def minute_=(x: Int)  // this is exact same trait as AbstractTime
}

class MyTime extends AbstractTime { // declared var, implemented var
  var hour = 200
  var minute = 300
}

class MyTimeGetSet extends AbstractTime { // declared var, implemented get set
  private[this] var h = 200
  private[this] var m = 300
  
  def hour = h
  def hour_=(x: Int) { h = x }
  def minute = m
  def minute_=(x: Int) { m = x }
}

class MyTime2 extends AbstractTime2 { // declared get set, implemented var
  var hour = 200
  var minute = 300
}

class MyTime2GetSet extends AbstractTime2 { // declared get set, implemented get set
  private[this] var h = 200
  private[this] var m = 300
  
  def hour = h
  def hour_=(x: Int) { h = x }
  def minute = m
  def minute_=(x: Int) { m = x }
}
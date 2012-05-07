class Point(val x: Int, val y: Int)

class RectangleWithoutTrait(val topLeft: Point, val bottomRight: Point) {
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

/**
 * here is the trait...!
 */
trait Rectangular {
  def topLeft: Point
  def bottomRight: Point
  
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

class Rectangle(val topLeft2: Point, val bottomRight: Point) extends Rectangular {
   def topLeft = topLeft2
  
}

val rect = new Rectangle(new Point(1,1), new Point(10, 10))
println(rect.left)
println(rect.right)
println(rect.width)
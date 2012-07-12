class Food
abstract class Animal {
  def eat(food: Food)
}

// class Grass extends Food
// class Cow extends Animal {
//   override def eat(food: Grass) {}
// }
// 
// class Fish extends Food
// val bessy: Animal = new Cow
// bessy eat (new Fish)

// ^^ doesn't compile, since eat(Food) cannot be overridden by eat(Grass)
// if it could, it would also be possible to serve a Fish to a Cow

abstract class Animal2 {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}

class Grass extends Food
class Cow extends Animal2 {
  type SuitableFood = Grass
  override def eat(food: Grass) {}
}

class Fish extends Food
val bessy: Animal2 = new Cow
// bessy eat (new Fish) // --> this doesn't compile, since Fish is not SuitableFood
//bessy eat (new Grass) // --> this doesn't compile as well, since bessy is defined as Animal2. 
                        // So compiler has on Animal2 level a SuitableFood method...
val bissy: Cow = new Cow
bissy eat (new Grass) // this does compile
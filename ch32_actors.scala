import scala.actors._

object SillyActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("I'm acting!")
      Thread.sleep(1000)
    }
  }
}

object SeriousActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("To be or not to be.")
      Thread.sleep(1000)
    }
  }
}

SillyActor.start(); SeriousActor.start()
  
// using actor() method produces actor and directly starts it.
import scala.actors.Actor._
val seriousActor2 = actor {
  for (i <- 1 to 5)
    println("That is the question.")
  Thread.sleep(1000)
}

val echoActor = actor {
  while(true) {
    receive {
      case msg => println("received message: " + msg)
    }
  }
}

echoActor ! "bla"

// in case of manual creation of actor: it needs to be started before it will do something with the received message

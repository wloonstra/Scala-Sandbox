import scala.actors.Actor

object NameResolver extends Actor {
  import java.net.{InetAddress, UnknownHostException}
  
  def act() {
    react {
      case (name: String, actor: Actor) =>
        actor ! getIp(name)
        act()
      case "EXIT" =>
        println("Name resolver existing.")
        // quit
      case msg =>
        println("Unhandled message: " + msg)
        act()
    }
  }
  
  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }
}

NameResolver.start()
NameResolver ! ("www.scala-lang.org", self)
self.receiveWithin(0) { case x => x }
NameResolver ! ("wwwwww.scala-lang.org", self)  
self.receiveWithin(0) { case x => x }

// doenst work. needs more investigation!
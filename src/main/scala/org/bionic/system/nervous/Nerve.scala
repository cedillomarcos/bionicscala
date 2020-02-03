package org.bionic.system.nervous

import akka.actor.Actor

trait NerveTermination extends Actor {

  def send[T](event: => T):Unit

}

class Nerve extends NerveTermination {

  override def send[T](event: => T): Unit = ???

  override def receive: Receive = { //  Receiving message

      case "hello" => println("hello back at you")
      case _       => println("huh?")
  }
}
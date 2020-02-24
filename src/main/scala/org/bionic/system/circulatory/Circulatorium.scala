package org.bionic.system.circulatory

import akka.actor.Actor
import atmospheric.Air
import org.bionic.system.respiratory.RespiratoryTract.{airBronchi, airInspired, airTrachea}

object Circulatorium {

  private val heart = Heart()

  class NerveHeart extends Actor {
    import context._
    override def receive: Receive = {
      case x => { heart.action(_) }
    }
  }


  case class Heart(){

    def action(action:String) = action match {
      case "Diastole" => println("Diastole")
      case "Systole" => println("Sytole")
    }
  }
}

package org.bionic.system.nervous

import akka.actor.{Actor, ActorSystem, Props}
import org.bionic.system.circulatory.Circulatorium
import org.bionic.system.nervous.central.Medulla.{MedullaReceptors, medullaSystem}
import org.bionic.system.respiratory.RespiratoryTract.NerveLungs

/**
 * Spinal cord acts as a bus interchange messages between the central nerves system and
 * peripheric system
 *
 * The messages that travel in the spinal cord are:
 * - Efferent Nervs --> From medulla to muscle
 * - Afferent Nervs --> From receptors to medulla
 *
 */
object SpinalCord {

  //To medulla
  val aefferent = medullaSystem.actorOf(Props[AfferentNerves], "Afferent")

  /*
    From medulla to muscle send
   */
  class EfferentNerves extends Actor {
    import context._

    val lungs = actorOf(Props[NerveLungs], name = "Lungs")
    val heart = actorOf(Props[NerveHeart], name = "Heart")

    override def receive: Receive = {
      case "Breath" => lungs ! "Inspiration"
      case "Heart" => heart ! "Pump"
    }
  }

  /*
   From receptors to medulla arrival
   */
  class AfferentNerves extends Actor {
    import context._
    val medulla = actorOf(Props[MedullaReceptors], name = "Medulla")

    override def receive: Receive = {
      case x => medulla ! x
    }
  }
}

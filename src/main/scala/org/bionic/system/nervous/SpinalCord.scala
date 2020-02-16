package org.bionic.system.nervous

import akka.actor.{Actor, ActorSystem, Props}
import org.bionic.system.nervous.central.Medulla.{MedullaReceptors, medullaSystem}
import org.bionic.system.respiratory.RespiratoryTract.Lungs.NerveLungs

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

  val aefferent = medullaSystem.actorOf(Props[AfferentNerves], "Afferent")

  /*
    From medulla to muscle send
   */
  class EfferentNerves extends Actor {
    import context._

    val lungs = actorOf(Props[NerveLungs], name = "Lungs")

    override def receive: Receive = {
      case "Breath" => lungs ! "Inspiration"
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

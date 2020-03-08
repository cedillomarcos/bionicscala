package org.bionic.system.nervous.central

import java.util.concurrent.Executors

import akka.actor.{Actor, ActorSystem, Props}
import org.bionic.system.nervous.SpinalCord.{EfferentNerves}
import org.bionic.system.nervous.SpinalCord
import utils.Scheduler

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

/**
 * Medulla  or Medulla oblongata object actions
 * Spanish (Bulbo Raquideo)
 *
 * Respiration is regulated by groups of chemoreceptors.
 *
 * These sensors detect changes in the acidity of the blood; if, for example,
 * the blood becomes too acidic, the medulla oblongata sends electrical signals to
 * intercostal and phrenical muscle tissue to increase their contraction rate
 * and increase oxygenation of the blood. The ventral respiratory group
 * and the dorsal respiratory group are neurons involved in this regulation.
 *
 * The pre-Bötzinger complex is a cluster of interneurons involved in the respiratory function of the medulla.
 *
 * This section of the brain helps transfer messages to the spinal cord and the thalamus, which is in the brain,
 * from the body. The main function of the thalamus is to process information to and from the spinal cord and the cerebellum.
 *
 * The medulla oblongata helps regulate breathing, heart and blood vessel function, digestion, sneezing, and swallowing.
 * This part of the brain is a center for respiration and circulation.
 *
 * Regula el ritmo cardíaco del organismo y controlar su funcionamiento cardiovascular.
 * Regula la presión arterial.
 * Regula y controla las funciones viscerales.
 * Regula el sistema respiratorio.
 * Participa en los procesos de deglución.
 * Regula la secreción de jugos digestivos.
 * Controla el vómito, la tos y el estornudo, así como la acción de los músculos que se requieren para realizar tales acciones.
 *
 * https://es.wikipedia.org/wiki/Aparato_respiratorio#Control_de_la_ventilaci%C3%B3n
 *
 */

sealed trait MedullaFunctions {
  def breathAtInterval[T](interval: FiniteDuration)(event: => T)(implicit ec: Scheduler): Unit
  def heartAtInterval[T](interval: FiniteDuration)(event: => T)(implicit ec: Scheduler): Unit
}

object Medulla {

  ///from medulla to organs
  val medullaSystem = ActorSystem("MedullaSystem")
  val efferent = medullaSystem.actorOf(Props[EfferentNerves], "Efferent")

  implicit val executor = ExecutionContext.fromExecutor(Executors.newSingleThreadExecutor())

  private var breathRTM = 4000.millisecond
  private var hearRTMss = 1.second

  //private[this] val spinal = SpinalCord()

  def start() = {

    val breathRtm =
      medullaSystem.scheduler.scheduleWithFixedDelay(Duration.Zero, breathRTM, efferent, "Breath")
    val heartRtm =
      medullaSystem.scheduler.scheduleWithFixedDelay(Duration.Zero, hearRTMss, efferent, "Diastole")
  }

  class MedullaReceptors extends Actor {
    override def receive: Receive = {
      case "(+)CO2" => println ("High CO2")
    }
  }
}

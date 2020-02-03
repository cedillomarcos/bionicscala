package org.bionic.system.nervous.central

import org.bionic.system.nervous.Scheduler

import scala.concurrent.duration._

/**
 * Medulla object actions
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
 */

sealed trait MedullaFunctions {
  def breathAtInterval[T](interval: FiniteDuration)(event: => T)(implicit ec: Scheduler): Unit
  def heartAtInterval[T](interval: FiniteDuration)(event: => T)(implicit ec: Scheduler): Unit
}

object Medulla {

  private var breathRTM = 4000.millisecond
  private var hearRTMss = 4

  //private[this] val spinal = SpinalCord()

  def start() = {

    implicit val clockLife: Scheduler = Scheduler.apply(1)





  }

}

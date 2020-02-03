package org.bionic.system.respiratory


import org.bionic.system.nervous.{Nerve, NerveTermination}

import scala.concurrent.ExecutionContext
import scala.reflect.ClassTag

/**
 * The lung capacity depends on the person's age, height, weight, sex,
 * and normally ranges between 4,000 and 6,000 cm3 (4 to 6 L).
 *
 */

sealed trait Breath {

 // def cycle[T](e: EventHandler[T])(implicit sc: SpinalCord)
}

object Breath {

    def conductionZone()



}




object Lungs {

 // def apply()(implicit sc: SpinalCord): Unit = {
 def apply(): Lungs = new Lungs()

 private class Lungs extends NerveTermination {

  override def send[T](event: => T): Unit = ???

  override def receive: Receive = {
    case "Inspiration" => {
       println("Inpiration")
    }
    case "Expiration" =>
  }

 }


 private def breath() = {
/*
    //aire de la atmosfera al pulmon
    ventilation

    exhange:
        //llegada de la sangre al pulmon
        perfusion
        // intercambio del o2 y co2
        difussin
    // transportet
    transport

 */
 }



  override def recive[T](event: => T): Unit = ???

  override def send[T](event: => T): Unit = ???
}

package org.bionic.system.respiratory


import akka.actor.Actor
import atmospheric.Air
import org.bionic.system.nervous.{Nerve, NerveTermination}

import scala.concurrent.ExecutionContext
import scala.reflect.ClassTag

/**
 * The lung capacity depends on the person's age, height, weight, sex,
 * and normally ranges between 4,000 and 6,000 cm3 (4 to 6 L).
 *
 */
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

sealed trait Breath {

 // def cycle[T](e: EventHandler[T])(implicit sc: SpinalCord)
}

object RespiratoryTract {

  var airInspired: Air = null

  def apply(implicit air:Air) = {
    this.airInspired = air
    Lungs.ventilation( bronchi(trachea) )
  }

  private def trachea( air: Air ): Air = {
    air
  }

  //Humidification and temperature
  private def bronchi(f:Air => Air)(implicit air: Air): Air = {
    println(f(air))
    var PiO2 = AlveolarAir.pressionAirInspired(air.pression(),
                                               AlveolarAir.pH2OByTemp,
                                               AlveolarAir.FiO2(air.pO2, air.pression()))
    air.pO2 = PiO2
    air.pH2O = AlveolarAir.pH2OByTemp()
    air
  }

  /***
   * Lungs that inspiration and expiracion air
   *
   *
   */
  object Lungs {

    var airInspired: Air = null

    // def apply()(implicit sc: SpinalCord): Unit = {
    def ventilation(implicit air: => Air)  = {
      this.airInspired = air
    }

    class NerveLungs extends Actor {
      override def receive: Receive = {
        case "Inspiration" => {
          println("Inpiration.......")
          breathing ()
        }
      }
    }

    private def breathing () = {

      println(airInspired)
      interchange(airInspired)

    }

    /*
   class LungsNervs extends NerveTermination {

    override def send[T](event: => T): Unit = ???

    override def receive: Receive = {
      case "Inspiration" => {
         println("Inpiration")
         //breathing ()
      }
      case "Expiration" => println("Expiration")
    }

   }*/

    private def interchange(implicit air: => Air): Unit ={

    }

  }
}



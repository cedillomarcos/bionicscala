package org.bionic.system.respiratory


import akka.actor.{Actor, Props}
import atmospheric.Air
import org.bionic.system.nervous.SpinalCord.AfferentNerves
import org.bionic.system.nervous.central.Medulla.{MedullaReceptors, medullaSystem}
import AlveolarAir._
import org.bionic.system.nervous.{Nerve, NerveTermination}


import scala.concurrent.ExecutionContext
import scala.reflect.ClassTag

/**
 * The lung capacity depends on the person's age, height, weight, sex,
 * and normally ranges between 4,000 and 6,000 cm3 (4 to 6 L).
 *
 *
 * En condiciones de reposo y respiración tranquila una persona normal consume unos 250 ml de oxígeno y produce unos 200 ml de dióxido de carbono. La relación
 *
 * R = producción de carbónico/ consumo de oxígeno
 */
object RespiratoryTract {
  implicit var airInspired:Air = null
  val airTrachea = Trachea().air(_)
  val airBronchi = Bronchi().air(_)
  val lungs = Lungs()

  def apply(air:Air) = {
    this.airInspired = air
    air
  }

  case class Trachea() {
     def air(air: Air):Air = {
       println("Trachea" + air)
       air
     }
  }

  case class Bronchi(){
    def air(air:Air):Air = {
      (changePression andThen addHumidity)(airInspired)
    }

    val addHumidity = (air:Air) => {
      val airHum = air.copy()
      airHum.pH2O = pH2OByTemp(37)
      println("Bronchi" + airHum)
      airHum
    }

    val changePression = (air:Air) => {
      val PiO2 = pressionAirInspired(air.pression(),pH2OByTemp,FiO2(air.pO2, air.pression()))
      val airChange = air.copy(pO2 = PiO2)
      airChange
    }
  }


  class NerveLungs extends Actor {
    import context._
    override def receive: Receive = {
      case x:"Inspiration" => {
        println("Inpiration.......")
        lungs.action(x)
      }
    }
  }

  /***
   * Lungs that inspiration and expiracion air
   *
   *Volumen de respiración pulmonar en reposo: cantidad de
   *  aire que inspiramos (o espiramos) en cada respiración en condiciones de reposo (500 mL de aire).
   *
   *  Volumen de reserva inspiratorio: cantidad máxima de aire que logramos introducir en nuestros
   *  pulmones después de realizar una inspiración normal (2500 mL de aire)
   */
  case class Lungs() {

    //(CRF) (FRC = Functional Residual Capacity)
    var FRC:Double = 2300

    val aefferent = medullaSystem.actorOf(Props[AfferentNerves], "Afferent")
    //var airInspired: Air = null

    // def apply()(implicit sc: SpinalCord): Unit = {
    //def ventilation(implicit air: => Air)  = {
    //  this.airInspired = air
    //}

    def action(action:String):Air = action match {
      case "Inspiration" => interchange((airTrachea andThen(airBronchi))(airInspired))
      case "Expiration" => (airBronchi andThen(airTrachea))(airInspired)
    }

    private def breathing () = {
      println(airInspired)
      //nterchange(airInspired)
      //aefferent ! "(+)CO2"
    }

    def CVP(): Unit = {

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

    private def interchange(implicit air: => Air): Air ={
      println(air)
      air
    }

  }
}





/*
def apply(airInspired:Air): Air = {
  this.air = airInspired
  /*
  //bronchi(trachea,air)
  //Lungs.ventilation( bronchi(trachea) )
  */

  air
}*/

/*
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
  air.pH2O = AlveolarAir.pH2OByTemp(37)
  air
}
*/



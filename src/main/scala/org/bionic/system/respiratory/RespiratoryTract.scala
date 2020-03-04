package org.bionic.system.respiratory

import org.bionic.system.nervous.SpinalCord.AfferentNerves
import org.bionic.system.nervous.central.Medulla.{MedullaReceptors, medullaSystem}
import AlveolarAirFunction._
import akka.actor.Actor
import atmospheric.Air
import org.bionic.system.nervous.{Nerve, NerveTermination, SpinalCord}

/**
 * The lung capacity depends on the person's age, height, weight, sex,
 * and normally ranges between 4,000 and 6,000 cm3 (4 to 6 L).
 *
 *
 * En condiciones de reposo y respiración tranquila una persona normal consume u
 * nos 250 ml de oxígeno y produce unos 200 ml de dióxido de carbono. La relación
 *
 * R = producción de carbónico/ consumo de oxígeno
 */
object RespiratoryTract {
  implicit var airInspired:Air = null
  private val airTrachea = Trachea().air(_)
  private val airBronchi = Bronchi().air(_)
  private val lungs = Lungs()

  def apply(air:Air) = {
    this.airInspired = air
    air
  }



  /**
   *
   */
  case class Trachea() {
     def air(air: Air):Air = {
       println("Trachea" + air)
       air
     }
  }

  /**
   *
   */
  case class Bronchi(){

    def air(air:Air):Air = {
      daltonLaw (changePression andThen addHumidity)(airInspired)
    }

    val addHumidity = (air:Air) => {
      val airHum = air.copy()
      airHum.pH2O = pH2OByTemp(37)
      airHum
    }

    /***
     en el alveolo habrá a BTPS
   Oxígeno 19,61% 149 mmHg
Dióxido de carbono 0,03% 0,2 mmHg
Nitrógeno 74,18% 563,8 mmHg
Vapor de agua 6,18% 47 mmHg

    ***/
    //hay que compesar el gass por la ley de datlon
    val changePression = (air:Air) => {
      val PiO2 = pressionAirInspired(air.pression(),pH2OByTemp, FiO2(air.pO2, air.pression()))
      val airChange = air.copy(pO2 = PiO2)
      airChange
    }

    def daltonLaw(f: Air => Air)(implicit air:Air):Air = {
      val airComposed = f(air)
      val diff = airComposed.pression() - air.pression()

      var btps = airComposed.copy(pN = air.pN - diff)
      btps.pH2O = airComposed.pH2O
      btps
    }

  }



  class NerveLungs extends Actor {
    import context._
    override def receive: Receive = {
      case x:"Inspiration" => {
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



    def action(action:String):Air = action match {
      case "Inspiration" => interchange((airTrachea andThen (airBronchi)) (airInspired))
      case "Expiration" => (airBronchi andThen(airTrachea))(airInspired)
    }

    private def interchange(implicit air: => Air): Air ={
      println("Interchange-->" + air)

      //pression venosa
      var PvCO2 = 45
      var PvO2 = 40

      //Pression alveolar valores de referencia
      //var PACO2 = 40 var PAO2 = 107

      var PressAO2 = PAO2(air.pression(),pH2OByTemp,FiO2(air.pO2,air.pression()))
      println("Pression alveolar==>" + PressAO2)

      //pression arterial
      var PaCO2 = 40
      var PaO2 = 100


      air
    }


    private def bioreceptors()  ={
      SpinalCord.aefferent ! "(+)CO2"
    }

  }
}






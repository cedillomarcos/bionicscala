package org.bionic.system.circulatory

/**
 * Blood Cell as a monad
 *
 */
class BloodCell {

  private val maxO2:Int = 4
  private var CO2 = null
  private var O2 = null
  private var Cl = null

  //hemoglobine chain
  var hem:Array[String] = new Array[String](4)
  // oxihemoglobina Hb02
  // desoxihemoglobina Hb
  // carboxihemoglobina (Co2)

  def T:String = "O2"

  def diffusion[Gas](gas:Gas) = {
      gas match {
        case CarbonDioxide => println()
        case Oxygen => println()
      }
  }


   //iplicitamente cambia el co2 por cloro y se aosciada

  //ompliocitament el 02 cambia



  def transport[T](gas:Double) = {
    T match {
      case "CO2" => println("Co2")
      case "O2" => println("O2")
    }
  }

  def atp() = {

  }
  /*
  //Hb + 4O2
  private def addHemoglobine() = {

  }


  private def energyATP(): Unit = {

  }
*/
}



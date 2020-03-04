package org.bionic.system.circulatory

/**
 * Blood Cell as a monad
 *
 * // oxihemoglobina Hb02
 * // desoxihemoglobina Hb
 * // carboxihemoglobina (Co2)
 */
class BloodCell {

  private val maxO2:Int = 4

  //Flag de control
  //hemoglobine chain initial filled with hidrogenion
  val Hb = new Array[Gas](4) :+ H


  def diffusion[G <: Gas, F <: BioMin](gas: G)(salt: F): G = {
    gas match {
        case CO2 if salt == Cl => BHor()
        case O2 if salt == HCO3 => Haldane(gas)
        case _ => Nil
    }
    return gas
  }



  //
  //1.- el co2 se une al h2O ==> HCO3(bicarbonato) + H => HHb
  //2.- se lo salta y se une a la Hb directamente HbCo2
  //Recoge el 02 en el pulmon y expulsa el co2
  private def Haldane(gas: Gas)(bicarb: BioMin): Unit = {

   // Hb.find(_ == "H")

    val hidrogenon = Hb(0)
    Hb(0) = gas
    disasociate(bicarb,hidrogenon)


    val CO2 = Hb(1)
    Hb(1) = gas

    //saca cloro
  }

  private def disasociate(bicarb:BioMin,gas: Gas):Enzime = bicarb match { case HCO3 => H2CO3 }

  //Expulsa el O2 en los tejidos
  private def BHor(): Unit = {
    //entra cloro

  }

   //iplicitamente cambia el co2 por cloro y se aosciada

  //ompliocitament el 02 cambia
  /*
  //Hb + 4O2
  private def addHemoglobine() = {

  }


  private def energyATP(): Unit = {

  }
*/
}



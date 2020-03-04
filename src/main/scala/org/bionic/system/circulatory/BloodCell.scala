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

  //hemoglobine chain
  var hem:Array[Gas] = new Array[Gas](4)



  def diffusion[G <: Gas](gas: G)(salt: BioMin):G = {
    gas match {
        case CO2 if salt == Cl => BHor()
        case O2 if salt == HCO3  => Haldane()
    }
    return gas
  }



  //
  //1.- el co2 se une al h2O ==> HCO3(bicarbonato) + H => HHb
  //2.- se lo salta y se une a la Hb directamente HbCo2
  //Recoge el 02 en el pulmon y expulsa el co2
  private def Haldane(): Unit = {



    //saca cloro

  }

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



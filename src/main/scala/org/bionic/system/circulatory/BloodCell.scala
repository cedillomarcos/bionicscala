package org.bionic.system.circulatory



class BloodCell {

  private val maxO2:Int = 4

  private var value = null

  def T:String = "O2"

  def diffusion(gas:Double) = {

  }

  def combine() = {

  }

  def transport[T](gas:Double) = {
    T match {
      case "CO2" => println("Co2")
      case "O2" => println("O2")
    }
  }
  /*
  //Hb + 4O2
  private def addHemoglobine() = {

  }


  private def energyATP(): Unit = {

  }
*/
}



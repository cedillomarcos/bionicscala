package org.bionic.system.circulatory

/**
 * Blood Cell as a monad
 *
 * // oxihemoglobina HbO
 * // desoxihemoglobina Hb
 * // carboxihemoglobina (HHbCO2)
 *
 * CO2 + H2O ⇔ H2CO3 ⇔ H+ + HCO3-
 */

sealed trait Hemo
case object HbCO2 extends Hemo { val name="carbaminohemoglobin" }
case object HbO2 extends Hemo {  val name="Oxihemoglobin" }

class BloodCell {

  //hemoglobine chain initial filled with hidrogenion
  val Hb = new Array[Hemo](4)
  Hb(0)=HbCO2
  var flag:BioMin = Cl //Flag Control

  def diffusion[G <: Gas, F <: BioMin](gas: G)(implicit flag: F): G = {
    gas match {
        case CO2 if flag == Cl => BHor()        // Low pH
        case O2 if flag == HCO3 => Haldane(gas) // High pH
        case _ => Nil
    }
    return gas
  }

  //
  //1.- el co2 se une al h2O ==> HCO3(bicarbonato) + H => HHb
  //2.- se lo salta y se une a la Hb directamente HbCo2
  //Recoge el 02 en el pulmon y expulsa el co2
  private def Haldane(gas: Gas)(implicit bicarb: BioMin): Gas  = {

   // Hb.find(_ == "H")

    val gHb = Hb(0)

    (gas, gas) = react(H,HbCO2)


  //  map[Tuple2[Gas,Gas]](react(H,CO2))

    //rotatedView(1)
    //saca cloro
    CO2
  }


  def compose[A, B, C] (f: A => B, g: B => C): A => C = f andThen g

  def react (A:Gas, B:Gas):(Gas,Gas) = (A,B) match {
     case ()
     case (CO2,H) => (H,CO2)
  }
  def react2 (g:Hydron)(f:Acid):(BioMin,Gas) = f match { case HCO3 if g == H => (H2O,CO2) }


  //HCO2 --> H + CO2
  // H + HCO3 --> H20 + C02
  private def map[B:(Gas,Gas), C:(Gas,Gas), D:(Gas,Gas)](f: B => C, quimic: D): B => C = {
    f
  }



  private def rotatedView(i:Int)=Hb.drop(i)++Hb.take(i)

  //Expulsa el O2 en los tejidos
  private def BHor(): Unit = {
    //entra cloro

  }

}





package atmospheric

/**
 * Atmospheric air
 *
 */
abstract class AirS {
  def pO2 : Double = 0.0
  def pCO2 : Double = 0.0
  def pN: Double = 0.0

  var pH2O: Double = 0.0
  var other: Double = 0.0
}

case class Air (
                 var pO2 : Double = 0.0,
                 var pCO2 : Double = 0.0,
                 var pN: Double = 0.0 ) {

  var pH2O: Double = 0.0
  var other: Double = 0.0


  def pression(): Double = pO2 + pCO2 + pN + pH2O + other

  override def toString()
  = s"[Atm Press O2: $pO2|CO2:$pCO2|N:$pN|H2O:$pH2O|Other:$other|TOT:$pression]"

}

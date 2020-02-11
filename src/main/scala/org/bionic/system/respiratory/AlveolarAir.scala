package org.bionic.system.respiratory

import atmospheric.Air

/**
 * Alveolar Air functions that are successed
 *
 * There are clean of inxpiracion & expiration
 *
 *  PAxx --> Alveolar GAS
 *  Paxx --> Arterial GAS
 *
*/
object AlveolarAir {

  /**
   * Pression Vaopor Water at temperature in mmHg
   * @param temp
   * @return
   */
  //if temp are 37 º the pression are 47 mmhg
  def pH2OByTemp(temp: Int = 37): Int = 47

  /**
   * Pression of any gas inspired with humidity
   * <eq>
   * PiX = (PB - PH2O) * FiX
   * </eq>
   * Pix = Air inspired pression
   * PB = Barometric pression
   * PH2O = Pression Water
   * FiX = fraccion inspired gas
   *
   * @param pH2OByTemp
   * @param FiX
   * @return
   */
  def pressionAirInspired(Patm: Double, pH2OByTemp: Int => Int, FiX: Double ) = (Patm - pH2OByTemp(37)) * FiX

  /**
   * FiO2 in 0,percent
   * @param PO2
   * @param PatmTot
   * @return
   */
  def FiO2(PO2: Double, PatmTot: Double) : Double = PO2 / PatmTot

  /**
   * Alveolar Pression Oxygen equation
  * PAO2 = FiO2 (Patm - PH2O) - (PaCO2 / R) ; R = 0.8
  */
  def PAO2(Patm: Double, pH2OByTemp: Int => Int, FiO2: Double): Double = ( FiO2 * (Patm - pH2OByTemp(37)) ) - (PaCO2() / 0.8)

  /**
   *  Arterial pression of C02 are 40 mmHG
   *  PaCO2
   */
  def PaCO2(): Double = 40.0

  /**
   *
   * alveolar - arterial gradient
   */
  def gradAaO2(PAO2:Double, PaO2: Double) : Double = PAO2 - PaO2
}

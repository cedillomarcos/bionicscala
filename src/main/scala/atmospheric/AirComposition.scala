package atmospheric

import atmospheric.AirComposition.pressAtAltitude

import scala.math.{abs, pow}

/**
 *  Air composition calculation
 *
 *  Oxygen at level sea are
 *  (O2) 209.460 porcentaje pression == 20.946 % == 0.21
 *
 */
// 20,9% de oxígeno (O2), 0,03% de dióxido de carbono (CO2) y 78% de nitrógeno (N).
/* nitrógeno (N2)	780.840 ppmv (78,084 %)
oxígeno (O2)	209.460 ppmv (20,946 %)
argón (Ar)	9.340 ppmv (0,934 %)
dióxido de carbono (CO2)	400 ppmv (0,04 %) */
object AirComposition {
     // pression at sea level mmHg
     val ppatmAtSeaLevel : Int = 760 // at sea level
     val airdensity: Double = 1.20 // kg/m3
     // Air porcentaje in the atm in total percent
     val ppmvO2 = 0.21//209.46
     val ppmvN2 = 0.78//780.84
     val ppmvCO2 = 0.004
     val ppmvH2O = 0.004
     val others = 0.092

     //STPD Standard Temperature Pression Dry
     def airDry(altitude: Int) : Air = {

       var air:Air = Air(
                    partialByAltitude(pressAtAltitude, altitude, ppmvO2),
                    partialByAltitude(pressAtAltitude, altitude, ppmvCO2),
                    partialByAltitude(pressAtAltitude, altitude, ppmvN2))

       air = DaltonLaw(pressAtAltitude, altitude, air)
       air
    }

    def DaltonLaw(f: Int => Int, altitude: Int, air: Air) : Air = {
      air.other = f(altitude) -  air.pression()
      air
    }

   /**
    *  It provides the relationship between atmospheric pressure
    *  and altitude according to the International Standard Atmosphere (ISA)
    *  Pure function
    */
   private def pressAtAltitude(H: Int): Int = abs(ppatmAtSeaLevel * pow((1 - 0.0000225577 * H), 5.2559)).toInt

  /**
   * PiX = Partial press by altituted of a gas
   * @param press
   * @param altitude
   * @param gas
   * @return
   */
   private def partialByAltitude(press: Int => Int, altitude: Int, gas: Double ) : Double = press(altitude) * gas




}

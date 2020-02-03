package atmospheric

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
     val ppatm : Int = 760 // at sea level
     val airdensity: Double = 1.20 // kg/m3
     // Air porcentaje in the atm in total percent
     val ppmvO2 = 209.460
     val ppmvN2 = 780.84
     val ppmvCO2 = 0.4

     //STPD Standard Temperature Pression Dry
     def airDry(temp:Int, altitude: Int) : Air = {
        val ppm = pressByAltitude(altitude)

        val air:Air = new Air(ppm * ppmvO2,
                      ppm * ppmvCO2,
                      ppm * ppmvN2,
                      0)
        return air
    }

    /*
    *  It provides the relationship between atmospheric pressure
    *  and altitude according to the International Standard Atmosphere (ISA)
    */
    def pressByAltitude(H: Int): Int = {
       return abs(ppatm * pow((1 - 0.0000225577 * H), 5.2559)).toInt
    }

   def pH2OByTemp(temp : Int) : Int = {
     //if temp are 37 º the pression are 47 mmhg
     return 47
   }
}

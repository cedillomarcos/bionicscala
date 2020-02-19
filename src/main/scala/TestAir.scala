import atmospheric.{Air, AirComposition}
import org.bionic.system.circulatory.BloodCell

object TestAir extends App {
  // altitude 0 pression 760 mmHG
  // Oxígeno 20,98% 159,45 mmHg
  // Dióxido de carbono 0,04% 0,3 mmHg
  // Nitrógeno 78,06% 593,26 mmHg
  // Argón y otros gases 0,92% 6,99 mmHg
  var air = AirComposition.airDry(0)
  println(air)
  println((air.pO2 * 100) / air.pression())


  var airT = Air(1,1,1)

  println(airT)
  println(airT.pression())
 // airT.daltonLaw(760)



  val bloodcell = new BloodCell()
  //bloodcell.transport["CO2"](20)
  bloodcell.transport["O2"](20)
}




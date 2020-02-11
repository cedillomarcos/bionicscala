import atmospheric.AirComposition

object TestAir extends App {
  // altitude 0 pression 760 mmHG
  // Oxígeno 20,98% 159,45 mmHg
  // Dióxido de carbono 0,04% 0,3 mmHg
  // Nitrógeno 78,06% 593,26 mmHg
  // Argón y otros gases 0,92% 6,99 mmHg
  var air = AirComposition.airDry(0)
  println(air)
  println((air.pO2 * 100) / air.pression())

}




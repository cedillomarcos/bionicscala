package atmospheric
import org.scalatest._

class AirCompositionTest extends FlatSpec with Matchers {

  behavior of "Air Composition"

  "Air at sea level (0m)" should "760 mmhg of pression" in {
    AirComposition.airDry(0).pression() shouldEqual 760
  }

  it should "have 21% (159,6 mmHg) of O2 pression " in {
    AirComposition.airDry(0).pO2 shouldEqual 159.6
  }

  it should "have 0.04% (0,3 mmHg) of CO2 pression " in {
    AirComposition.airDry(0).pCO2 shouldEqual 3.04
  }

  it should "have 78.06% (593,26 mmHg) of N2 pression " in {
    AirComposition.airDry(0).pN shouldEqual 593.256
  }


}

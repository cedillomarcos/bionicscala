package org.bionic.system.circulatory

import org.scalatest.{FlatSpec, Matchers}

class BloodCellTest extends FlatSpec with Matchers {

  behavior of "Blood Cell"



  "A BloodCell" should "diffuse inside O2 at high pressure" in {


    var bloodcell = new BloodCell()

    bloodcell.diffusion()


  }


  "A BloodCell" should "diffuse inside O2 ph >" in {


  }

}

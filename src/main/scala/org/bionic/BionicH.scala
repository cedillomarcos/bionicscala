package org.bionic

import org.bionic.system.nervous.central.Medulla
import org.bionic.system.respiratory.Lungs

class BionicH {

  var vitalSigns = new VitalSings()

  //Start the live order
  Medulla.start()
  //heart
  Lungs.apply()


}

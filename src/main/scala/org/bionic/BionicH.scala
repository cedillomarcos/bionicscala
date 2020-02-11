package org.bionic

import atmospheric.Air
import org.bionic.system.nervous.central.Medulla
import org.bionic.system.respiratory.{Lungs, RespiratoryTract}
import org.bionic.vitals.VitalSings


/**
 *
 */
case class BionicH(airInspiration: Air) {

  var air:Air = airInspiration
  var vitalSigns = new VitalSings()



  RespiratoryTract.apply()(air)
  //Start the live order
  Medulla.start()
  //heart




}

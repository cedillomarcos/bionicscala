package org.bionic

import java.util.Optional

import atmospheric.Air
import org.bionic.system.circulatory.BloodCell
import org.bionic.system.nervous.central.Medulla
import org.bionic.system.respiratory.Respiratorium.Lungs
import org.bionic.system.respiratory.Respiratorium
import org.bionic.vitals.VitalSings


/**
 *
 */
case class BionicH(airInspiration: Air) {

  var vitalSigns = new VitalSings()


  var airExpiration:Air =  Respiratorium.apply(airInspiration)
    //Start the live order
    Medulla.start()

  def start(): Unit ={
    println("Started....")
  }

  //heart


}

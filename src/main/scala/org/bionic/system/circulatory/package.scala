package org.bionic.system

package object circulatory {

  sealed trait Gas
  case object O2 extends Gas //oxygen
  case object CO2 extends Gas //dioxicarbonate

  sealed trait BioMin
  case object HCO3 extends BioMin //Bicarbonate
  case object Cl extends BioMin //Clorhine
}

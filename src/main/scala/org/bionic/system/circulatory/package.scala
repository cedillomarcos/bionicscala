package org.bionic.system

package object circulatory {

  sealed trait Gas {def name:String }
  case object O2 extends Gas { val name="Oxygen" }//oxygen
  case object CO2 extends Gas { val name="Dioxicarbonate" }
  case object H extends Gas { val name="Hidrogenion" }

  sealed trait BioMin
  case object HCO3 extends BioMin { val name="Bicarbonate" }
  case object Cl extends BioMin with Gas { val name="Clorhine" }

  sealed trait Enzime
  case object H2CO3 extends Enzime
}

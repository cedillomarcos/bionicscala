package org.bionic.system

package object circulatory {

  sealed trait Gas {def name:String }
  case object O2 extends Gas { val name="Oxygen" }//oxygen
  case object CO2 extends Gas { val name="Dioxicarbonate" }

  sealed trait Hydron
  case object H extends Hydron with Gas { val name="Hidrogenion" }

  sealed trait BioMin
  sealed trait Acid
  case object HCO3 extends BioMin with Acid { val name="Bicarbonate" }
  case object H2O extends BioMin { val name="Water" }
  case object Cl extends BioMin with Gas { val name="Clorhine" }


}

package org.bionic.system

package object circulatory {

  sealed trait Gas
  case object Oxygen extends Gas
  case object CarbonDioxide extends Gas
}

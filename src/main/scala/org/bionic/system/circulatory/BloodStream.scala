package org.bionic.system.circulatory

object BloodStream {

  var PH:Double = 7.4

  /**
   *
   * https://es.wikipedia.org/wiki/Gasometr%C3%ADa_arterial
   *Se considera que el pH de la sangre toma un valor fisiológico de 7,4. C
   * La relación entre la PaCO2 y el pH es muy estrecha:
   *
   * Por cada incremento en la PaCO2 de 20mmHg por encima de lo normal, el pH desciende 0,1 puntos.
   * Por cada descenso en la PaCO2 de 10mmHg por debajo de lo normal, el pH sube 0.1 puntos
   */

  case class VenousStream() {

  }

  case class ArterialStream(){

  }

}

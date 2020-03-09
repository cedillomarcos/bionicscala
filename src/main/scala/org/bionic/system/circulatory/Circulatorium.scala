package org.bionic.system.circulatory

import akka.actor.Actor
import atmospheric.Air
import org.bionic.system.nervous.SpinalCord
import org.bionic.system.respiratory.Respiratorium.{airBronchi, airInspired, airTrachea}

object Circulatorium {

  private val heart = Heart()

  def Minor(stream: BloodStream): BloodStream = {
    stream
  }

  def Pulmonary(stream: BloodStream): BloodStream = {
    stream
  }

  def Mayor(stream: BloodStream): BloodStream = {
    stream
  }

  def Systemic(stream: BloodStream): BloodStream = {
    stream
  }

 //heart -> lungs -> heart -> mayor -> sistemic


  class NerveHeart extends Actor {
    import context._
    override def receive: Receive = {
      case x => { heart.action(_) }
    }
  }

  /**
   * HEART Organ
   *
   */
  case class Heart(){
    implicit var stream = new BloodStream(){}

    def action(action:String) = action match {
      case "Diastole" => Diastole  //contractions
      case "Systole" => Systole //relax
    }

    private def Diastole(): Unit = { circulation() }

    private def Systole(): Unit = { circulation() }

    private def circulation() : Unit = {
      Minor(stream)
      Pulmonary(stream)
      Mayor(stream)
      Systemic(stream)
    }

    private def bioreceptors()  ={
      // Sensor O2 and CO2 in aorta
      SpinalCord.aefferent ! "(-)O2"
      SpinalCord.aefferent ! "(+)CO2"
    }

    /*
      GC(VM) ml/min
      VS ml/lat (Systolic Volumen) (70 ml/latido+-)
      FC Frecuency Heart (lpm)
     */
    private def VC(VS:Int,FC:Int) = VS * FC

  }
}

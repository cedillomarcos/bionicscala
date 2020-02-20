package utils
import scala.annotation.tailrec

object DMFV {


  //
  def miniaturize(matter: Double): Double = {
    @tailrec
    def shrinkAccumulator(matter: Double, scale:Double) : Double = {
      if( matter <= scale ) _
      else shrinkAccumulator( matter - (matter * 0.10), scale )
    }
    shrinkAccumulator(matter, 0.00075)
  }

}

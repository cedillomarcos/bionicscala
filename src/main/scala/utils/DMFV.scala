package utils
import scala.annotation.tailrec

object DMFV {

  //In centimetres
  def miniaturize(matter: Double): Double = {
    val scale:Double = 0.00075
    @tailrec def shrinkAccumulator(matter: Double) : Double = matter match {
        case x if x > scale => shrinkAccumulator(x * 0.10)
        case _ => matter
    }
    shrinkAccumulator(matter)
  }

}

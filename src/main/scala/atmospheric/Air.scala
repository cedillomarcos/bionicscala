package atmospheric

class Air(
  var pO2 : Double = 0.0,
  var pCO2 : Double = 0.0,
  var pN: Double = 0.0,
  var pH2O: Double = 0.0) {

  def pression(): Unit ={
    return pO2 + pCO2 + pN + pH2O;
  }
}

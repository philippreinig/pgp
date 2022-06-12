object Applier {

    def applyFuncsV1(fList: List[Double => Double], arg: Double): Double = {
        if (fList.isEmpty) arg
        else fList.foldLeft(arg){(result, f) => f(result)}
    }

    def applyFuncsV2(fList: List[Double => Double], arg: Double): Double = {
        if (fList.isEmpty) arg
        else Function.chain(fList)(arg)
    }

    def applyFuncsV3(fList: List[Double => Double], arg: Double): Double = {
        if (fList.isEmpty) arg
        else fList.reduce((f1,f2) => f1.andThen(f2))(arg)
    }

    def applyFuncsReverseV1(fList: List[Double => Double], arg: Double): Double = {
        if (fList.isEmpty) arg
        else fList.foldRight(arg){(f, result) => f(result)}
    }

    def applyFuncsReverseV2(fList: List[Double => Double], arg: Double): Double = {
        if (fList.isEmpty) arg
        else fList.reduce((f1,f2) => f1.compose(f2))(arg)
    }
  
    def applyFuncsArgs(fList: List[Double => Double], args: List[Double]): List[Double] = {
        var results = List[Double]()
        for(i <- 0 until fList.length){
            results = results ::: List(applyFuncsV1(fList.take(i+1), args(i)))
        }
        return results
    }
  
  def main(Args: Array[String]) = {
    val f1 = (x: Double) => 2 * x
    val f2 = (x: Double) => x+1
    val fList = List(f1, f2)
    println(applyFuncsV1(fList, 2))
    println(applyFuncsV2(fList, 2))
    println(applyFuncsV3(fList, 2))
    println(applyFuncsReverseV1(fList, 2))
    println(applyFuncsReverseV2(fList, 2))
    println(applyFuncsArgs(fList, List(1,2)))
  }
}

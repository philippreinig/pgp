import scala.math.sqrt

object Main {
  def primeStream(): Stream[Int] = {
    // TODO
  }

  def distanceNumberStream(): Stream[Int] = {
    // TODO
  }

  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (b == 0) {
      a.abs
    } else {
      gcd(b, a % b)
    }
  }

  def mangoldtExpStream(): Stream[Int] = {
    // TODO
  }
}
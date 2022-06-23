import scala.math.sqrt
import scala.collection.immutable.LazyList

object Main {
  def primeStream(stream: LazyList[Int] = LazyList.from(3,2)): LazyList[Int] = {
    stream.head #:: primeStream(stream.tail.filter(_ % stream.head != 0))
  }

  def distanceNumber(n: BigInt) : BigInt = {
    if (n == 0) 1
    else distanceNumber(n-1) + n
  }

  def distanceNumberStreamRec(): LazyList[BigInt] = {
    LazyList.from(0).map(x => distanceNumber(x))
  }

  def distanceNumberStreamScan(): LazyList[Int] = {
    LazyList.from(1).scan(1)((a,b) => a+b)
  }

  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (b == 0) {
      a.abs
    } else {
      gcd(b, a % b)
    }
  }

  def lcm(a: BigInt, b: BigInt): BigInt = {
    a * b / gcd(a, b)
  }

  def lcm(nums : LazyList[BigInt]) : BigInt = {
    if (nums.length == 0) return 1
    else if (nums.length == 1) nums.head 
    else lcm(nums.head, lcm(nums.tail))
  }

  def mangoldtExpStream(): LazyList[BigInt] = {
    LazyList.from(1).map(x => lcm(LazyList.range(1,x+1))/lcm(LazyList.range(1, x)))
  }

  def main(args: Array[String]) : Unit = {
    println("primeStream: " + primeStream().take(10).toList)
    println("distanceNumberStreamRec: " + distanceNumberStreamRec().take(10).toList)
    println("distanceNumberStreamScan: " + distanceNumberStreamScan().take(10).toList)
    println("mangoldtExpStream: " + mangoldtExpStream().take(10).toList)
  }
}
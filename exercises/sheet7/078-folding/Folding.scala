object Main {
  def charCount(list: List[String]): Int = {
    list.foldLeft(0)( (acc, x) => acc + length(x.toList))
  }

  def length[A](list: List[A]): Int = {
    list.foldLeft(0)((count, _) => count + 1)
  }

  def reverse[A](list: List[A]): List[A] = {
    list.foldLeft(List[A]())((a,b) => b :: a)
  }

  def concat[A](list1: List[A], list2: List[A]): List[A] = {
    list2.foldLeft(list1)((a,b) => a:+b)
  }

  def enumerate[A](list: List[A]): List[(Int, A)] = {
    list.zipWithIndex.map((elem, indx) => (indx, elem))
  }
  
  def main(args: Array[String]): Unit = {
    val l0: List[Int] = List()
    val l1: List[Int] = List(1, 2, 3, 4, 5, 6)
    val l2: List[Int] = List(7, 8, 9, 10, 11)
    val l3: List[String] = List("Lorem", "ipsum", "dolor", "sit", "amet")
    
    println(s"reverse($l0): " + reverse(l0))
    println(s"reverse($l1): " + reverse(l1))
    println(s"reverse($l2): " + reverse(l2))
    println(s"length($l0): " + length(l0))
    println(s"length($l1): " + length(l1))
    println(s"length($l2): " + length(l2))
    println(s"concat($l1, $l2): " + concat(l1, l2))
    println(s"enumerate($l2): " + enumerate(l2))
    println(s"enumerate($l0): " + enumerate(l0))
    println(s"charCount($l3): " + charCount(l3))
  }
}


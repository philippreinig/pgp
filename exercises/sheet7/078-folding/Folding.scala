object Main {
  def charCount(list: List[String]): Int = {
    // TODO
  }

  def length[A](list: List[A]): Int = {
    // TODO
  }

  def reverse[A](list: List[A]): List[A] = {
    // TODO
  }

  def concat[A](list1: List[A], list2: List[A]): List[A] = {
    // TODO
  }

  def enumerate[A](list: List[A]): List[(Int, A)] = {
    // TODO
  }
  
  def main(args: Array[String]): Unit = {
    val l0: List[Int] = List()
    val l1: List[Int] = List(1, 2, 3, 4, 5, 6)
    val l2: List[Int] = List(7, 8, 9, 10, 11)
    
    println(reverse(l0))
    println(reverse(l1))
    println(reverse(l2))
    println(length(l0))
    println(length(l1))
    println(length(l2))
    println(concat(l1, l2))
    println(enumerate(l2))
    println(enumerate(l0))
    println(charCount(List("Lorem", "ipsum", "dolor", "sit", "amet")))
  }
}


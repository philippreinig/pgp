object CallByName {
  var i  = 0;
  def return_1_with_callback(): Int = {
    println("Callback called")
    var t = i
    i += 1
    return t
  }

  def call_by_value(x: Int) = {
    println("call_by_value: " +  x)
    println("call_by_value: " +  x)
  }

  def call_by_name_1(x: => Int) = { 
    println("call_by_name_1: " +  x)
    println("call_by_name_1: " + x)
  }

  def call_by_name_2(x: => Int) = { 
  }

  def main(args: Array[String]): Unit =  {
    call_by_value(return_1_with_callback)
    call_by_name_1(return_1_with_callback)
    call_by_name_2(return_1_with_callback)
    
  }
}

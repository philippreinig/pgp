object Main {

  def isList(arg: Any) : Boolean = {
    return arg.isInstanceOf[List[_]]
  }
  
  def flatten2(coolList: List[Any]): List[Any] = {
    flatten(coolList)
  }
  
  def flatten(coolList: List[Any]): List[Any] = {
    if (coolList.isEmpty) coolList
    else if (coolList(0).isInstanceOf[List[Any]]) flatten(coolList(0).asInstanceOf[List[Any]]) ::: flatten(coolList.tail)
    else coolList(0) :: flatten(coolList.tail)
  }
  
  def main(Args: Array[String]): Unit = {
    val lager = List("Pale Lager", "Dark Lager")
    val pale_ale = List("India Pale Ale", "Amercian Pale Ale", 
                        "West Coast Pale Ale", "Island Pale Ale")
    val ales = List("Brown ale", "Scotch ale", pale_ale)
    val beers = List(ales, lager, "Pilsner")
    
    println("Nested lists of beers: " + beers)
    println("Flatted list of beers using flatten2: " + flatten2(beers))
    println("Flattened list of beers using flatten: " + flatten(beers))
  }
}
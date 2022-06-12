object Main {
  
  def flatten2(coolList: List[Any]): List[Any] = {
    //TODO: This function should flatten Lists of depth 2
    
    //HINT: You can also first implement flatten and then call it here, so you 
    //      won't have to implement it twice
  }
  
  def flatten(coolList: List[Any]): List[Any] = {
    //TODO: This function should flatten Lists of any depth
  }
  
  def main(Args: Array[String]): Unit = {
    val lager = List("Pale Lager", "Dark Lager")
    val pale_ale = List("India Pale Ale", "Amercian Pale Ale", 
                        "West Coast Pale Ale", "Island Pale Ale")
    val ales = List("Brown ale", "Scotch ale", pale_ale)
    val beers = List(ales, lager, "Pilsner")
    
    println(beers)
    println(flatten(beers))
  }
}
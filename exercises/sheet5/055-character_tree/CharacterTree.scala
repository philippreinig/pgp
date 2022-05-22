object CharacterTree {
  def print_tree(height: Int) : Unit = {
      print_tree_char(height, '*')
  }
  
def print_tree_char(height: Int, char: Char, level: Int) : Unit =  { 
    if (level <= 2 * height){
        print(" "  * ((2*height-level)/2))
        print(char.toString * level)
        print(" " * ((2*height-level)/2))
        println();
        print_tree_char(height, char, level + 2)
    }else{
        print(" " * ((2*height-1)/2))
        print(char)
        print(" " * ((2*height-level)/2))
        println();
    }
}

  def print_tree_char(height: Int, char: Char) : Unit = {
      print_tree_char(height, char, 1)
  }

  def main(args: Array[String]) : Unit = {
    var foo: Int = 14
    print_tree(foo)
    print_tree_char(foo, 'o');
  }
}
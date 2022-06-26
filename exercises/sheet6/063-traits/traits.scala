trait Human{
    //Instance variables definable
    var age = 2;

    //Default implementation possible
    def breathe() : Unit = {
        println("breathing");
    }

    def getName() : String;

    def printIdentity() : Unit;
}

trait Worker{
    var role;
    var salary;
}

class Stefan extends Human{
    @Override
    def name() : String = {
        return "Stefan";
    }

    def printIdentity() : Unit = {
        println(this.getName() + s" is $age years old");
           }

}


object Traits{
    def main(args: Array[String]) : Unit = {
        var stefan = new Stefan();
        stefan.printIdentity();
        stefan.breathe();
    }
}
interface Human{
    // Is implicitly public static final, no instance variables definable
    int age = 2;

    // Default implementation only available for static methods
    public static void breathe(){
        System.out.println("breathe");
    }

    public String getName();

    public void printIdentity();
}

class Stefan implements Human{

    @Override
    public String getName(){
        return "Stefan";
    }

    @Override
    public void printIdentity(){
        System.out.println(this.getName() + this.age);

    }
    
}





public class Interfaces{
    public static void main(String[] args){
        Stefan stefan = new Stefan();
        stefan.printIdentity();
        //Calls static method
        Human.breathe();

        //Accessing implicit static attribute
        System.out.println(stefan.age);

        // Does not compile
        // stefan.age = 5;

    }
}
abstract class Animal{
    public abstract void move();

    public abstract void breath();

}

class Fish extends Animal{
    public void move(){
        System.out.println("Swim in water");
    }

    public void breath(){
        System.out.println("Breath under water using germs");
    }

}

class Mammal extends Animal{
    public void move(){
        System.out.println("Move on land");
    }

    public void breath(){
        System.out.println("Breath air using lungs");
    }
}

class Lion extends Mammal{
    public void hunt(Mammal prey){
        System.out.println("Lion is hunting " + prey);
    }
}



public class AnimalPolymorphieExample {
    
}

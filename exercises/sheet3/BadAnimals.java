/*
instanceof Ersetzung  
Abgabe geschlossen seit 8. Mai 2022 um 23:15.
instanceof Ersetzung
Die Verwendung von instanceof ist allgemein als schlechter Stil angesehen und kann leicht vermieden werden. Das im Anhang befindliche Programm BadAnimals setzt stark auf die Nutzung von instanceof.

Ändern Sie das, indem Sie Verwendungen von instanceof durch dynamische Methodenlookups und Polymorphie ersetzen.

class BadAnimals {

	public static void printAnimalMoving(Animal a) {
		if (a instanceof Dog)
			((Dog)a).run();
		else if (a instanceof Cat)
			((Cat)a).tiptoe();
		else if (a instanceof Bird)
			((Bird)a).fly();
		else if (a instanceof Cheetah)
			((Cheetah)a).sprint();
		else if (a instanceof Sloth)
			((Sloth)a).hang();
		else
			System.out.println("I'm an Animal, I just move.");
	}

	public static void main(String[] args) {
		Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		Bird b = new Bird();
		Cheetah ch = new Cheetah();
		Sloth s = new Sloth();
		
		printAnimalMoving(a);
		printAnimalMoving(b);
		printAnimalMoving(d);
		printAnimalMoving(c);
		printAnimalMoving(ch);
		printAnimalMoving(s);
	}
}
		

class Animal {}

class Dog extends Animal {
	public void run() {
		System.out.println("Dogs run.");
	}
}

class Cat extends Animal {
	public void tiptoe() {
		System.out.println("Cats tiptoe.");
	}
}

class Bird extends Animal {
	public void fly() {
		System.out.println("Birds fly.");
	}
}

class Cheetah extends Animal {
	public void sprint() {
		System.out.println("Cheetah sprint.");
	}
}

class Sloth extends Animal {
	public void hang() {
		System.out.println("Sloths don't move!");
	}
}   

*/
class BadAnimals {

	public static void printAnimalMoving(Animal a) {
		a.move();
	}

	public static void main(String[] args) {
		// Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		Bird b = new Bird();
		Cheetah ch = new Cheetah();
		Sloth s = new Sloth();
		
		// printAnimalMoving(a);
		printAnimalMoving(b);
		printAnimalMoving(d);
		printAnimalMoving(c);
		printAnimalMoving(ch);
		printAnimalMoving(s);
	}
}
		

abstract class Animal {
    abstract public void move();
}

class Dog extends Animal {
    @Override
	public void move() {
		System.out.println("Dogs run.");
	}
}

class Cat extends Animal {
    @Override
	public void move() {
		System.out.println("Cats tiptoe.");
	}
}

class Bird extends Animal {
    @Override
	public void move() {
		System.out.println("Birds fly.");
	}
}

class Cheetah extends Animal {
    @Override
	public void move() {
		System.out.println("Cheetah sprint.");
	}
}

class Sloth extends Animal {
    @Override
	public void move() {
		System.out.println("Sloths don't move!");
	}
}   
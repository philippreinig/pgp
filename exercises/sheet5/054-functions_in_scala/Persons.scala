import java.time.LocalDate;
import java.time.Period;
import java.time.Month;

/*

### Iterable und Funktionen höherer Ordnung in Scala
In Scala implementiert die List das Iterable Trait, das viele Funktionen höherer Ordnung bereitstellt.
Diese sollen Sie in den folgenden Aufgaben verwenden, um Problemstellungen über einer Liste von Personen zu lösen.

1.  Nutzen Sie exakt eine Funktion höherer Ordnung, um eine Liste aller Nachnamen zu erhalten.
    Sie können davon ausgehen, dass kein Nachname mehrfach auftritt.

2.  Ermitteln Sie jetzt aus der Personenliste alle Personen, die im Oktober Geburtstag haben, mittels einer Funktion höherer Ordnung.
    Da Scala keine Schnittstellen für Datum und Zeit hat, werden hier die Schnittstellen aus Java verwendet (java.time.LocalDate).

3.  Berechnen Sie nun mittels genau einer Funktion höherer Ordnung das Alter jeder Person, um eine Liste mit dem Alter jeder Person zu erhalten
    (z.B. List(23, 69, 45, 74, 55)). Um das Alter einer Person zu bestimmen, können Sie die Java-Klasse java.time.Period verwenden.

4. Berechnen Sie nun das Durchschnittsalter aller Personen. Nutzen Sie hierfür ausschließlich Methoden, die in dem Iterable Trait definiert sind.

*/


class Person(
  val firstname: String,
  val lastname: String,
  val dayOfBirth: LocalDate
) {
  override def toString(): String = {
    firstname + " " + lastname
  }
}


object Main {
    // 1)
    def getLastName(person: Person): String = {
        person.lastname
    }

    def getAllLastNames(people: List[Person]): List[String] = {
        people.map(getLastName)
    }

    // 2)
    
    def getBirthMonth(person: Person) : Int  = {
        person.dayOfBirth.getMonthValue()
    }

    def getAllPeopleWithBirthdayInOctober(people : List[Person]): List[Person] = {
        people.filter(getBirthMonth(_) == Month.OCTOBER)
    }

    // 3)

    def getAge(person: Person) : Int = {
      Period.between(person.dayOfBirth, LocalDate.now()).getYears()
    }

    def getAllAges(people: List[Person]) : List[Int] =  {
      people.map(getAge)
    }

    // 4)
    def calculateAverageAge(people: List[Person]) : Int = {
      people.iterator.map(getAge(_)).sum / people.iterator.size
    }

  def main(args: Array[String]): Unit = {
    val persons = List(
      new Person("Kerstin", "Herz", LocalDate.of(1995, 5, 31)),
      new Person("Matthias", "Zimmermann", LocalDate.of(1950, 1, 23)),
      new Person("Jana", "Schultheiss", LocalDate.of(1973, 10, 10)),
      new Person("Jennifer", "Fischer", LocalDate.of(1944, 12, 4)),
      new Person("Andreas", "Kaufmann", LocalDate.of(1964, 4, 3))
    );

    println("All lastnames: " + getAllLastNames(persons))
    println("People with birthday in October: " + getAllPeopleWithBirthdayInOctober(persons))
    println("All ages: " + getAllAges(persons))
    println("Average age: " + calculateAverageAge(persons))
  }
}

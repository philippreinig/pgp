/**
 * ### Rocket Science! (Case Classes und Pattern Matching)
 * Sie haben bereits in Aufgabe 6.1 Case Classes kennen gelernt und wissen nun, was mithilfe dieser alles umsetzbar ist.
 * Nun sollen Sie Ihr erworbenes Wissen einmal nutzen, um Raketen zu filtern.
 * Eine Liste von Raketen ist durch Pattern Matching zu filtern, wobei jede Rakete, die das Muster erfüllt, dann in der Konsole ausgegeben werden soll.
 *
 * Über diese Raketen ist bekannt:
 * - sie besitzen einen Namen
 * - eine Anzahl von stages (Stufen)
 * - einen verwendeten Treibstoff
 *
 * Zum Beispiel:
 * - Die Falcon 9 ist eine 2-stufige Rakete, welche ein RP-1/LOX Gemisch als Treibstoff nutzt.
 * - Die Ariane 5 ist eine 2-stufige Rakete, welche ein LH2/LOX Gemisch als Treibstoff nutzt.
 * - Die Soyuz ist eine 2-stufige Rakete, welche ein RP-1/LOX Gemisch als Treibstoff nutzt.
 * - Die Proton ist eine 3-stufige Rakete, welche ein N2H4/UDMH Gemisch als Treibstoff nutzt.
 * - Die Delta IV ist eine 2-stufige Rakete, welche ein LH2/LOX Gemisch als Treibstoff nutzt.
 *
 * All diese Information sollen dann durch eine Case Class Rocket gespeichert werden.
 * ---
 * 1. Alle Raketen, die 2 Stages besitzen, sollen mithilfe von printIf2Stages ausgeben werden.
 * 2. Alle Raketen, die LH2/LOX als Treibstoff nutzen, sollen mithilfe von printIfLH2LOX ausgegeben werden
 * 3. Alle Raketen, deren Treibstoff LOX enthält, sollen mithilfe von printIfLOX ausgegeben werden.
 * Das Template für diese Aufgabe gibt Hinweise zur Erfüllung der Aufgabe.
 */


object RocketScience {
  def main(Args: Array[String]) = {
    val rockets = List(
      Rocket("Falcon 9", 2, "RP-1/LOX"),
      Rocket("Ariane 5", 2, "LH2/LOX"),
      Rocket("Soyuz", 2, "RP-1/LOX"),
      Rocket("Proton", 3, "N2H4/UDMH"),
      Rocket("Delta IV", 2, "LH2/LOX")
    )

    println("All rockets with 2 stages:")
    for (rocket <- rockets) {
      printIf2Stages(rocket)
    }

    println("All rockets with LH2/LOX:")
    for (rocket <- rockets) {
      printIfLH2LOX(rocket)
    }

    println("All rockets that use LOX as oxidizer:")
    for (rocket <- rockets) {
      printIfLOX(rocket)
    }
  }

  def printIf2Stages(rocket: Rocket) = {
    rocket.amtStages match {
      case 2 => println(rocket);
      case _ => ;
    }
  }

  def printIfLH2LOX(rocket: Rocket) = {
    rocket.fuel match {
      case x if x.contains("LH2/LOX") => println(rocket);
      case _ => ;
    }
  }

  def printIfLOX(rocket: Rocket) = {
    rocket.fuel match {
      case x if x.contains("LOX") => println(rocket);
      case _ => ;
    }
  }

  case class Rocket(name: String, amtStages: Int, fuel: String)
}
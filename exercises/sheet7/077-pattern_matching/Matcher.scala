/**

### Pattern Matching
In dieser Aufgabe sind verschiedene Case Classes gegeben, welche Messages eines Loggers darstellen. Diese sollen verschieden formatiert werden.
Dazu soll ausschließlich matching auf dem übergebenen Paramter msg genutzt werden, soweit nicht anders erwähnt.

1. Vor jeder Message soll der Typ der Message angehangen werden z.B. wird Info(content: "Foo") zu Info: Foo bei der Formatierung.
    Dafür kennen Sie verschiedene Methoden z.B. Constructor Pattern Matching aus vorherigen Übungen.
    Machen Sie sich jedoch ebenfalls mit Type Pattern Matching vertraut und nutzen Sie dieses ebenso in dieser Aufgabe an passenden Punkten.

2. Modifizieren Sie Ihre msg_format(msg: Any) Funktion, damit Debug Messages zusätzlich zu Ihrer bisherigen Formatierung auch noch basierend auf der Liste von Events formatiert werden.
    Wenn die Eventliste mindestens zwei Elemente enthält, soll lediglich das letzte angezeigt werden. Andernfalls sollen keine Events ausgegeben werden.
    Matchen Sie hier wieder ausschließlich auf dem Value msg, welcher ursprünglich übergeben wurde.

3. Bauen Sie die Funktion debug_filter() aus. Falls eine Debug Message nur ein Event enthält, soll diese nicht ausgegeben werden; falls sie jedoch mit dem Wort “Initialization” beginnt,
    soll die ganze List ausgegeben werden.
    Matchen Sie hierbei nur auf der Liste selbst und ohne Zuhilfenahme von if-Bedingungen.
*/

abstract class Message {
  val content: String
}

case class Error(time: Long, content: String) extends Message {
  override def toString() = {
    s"$content happened at $time"
  }
}

case class Info(content: String) extends Message {
  override def toString() = {
    s"$content"
  }
}

case class Warn(severity: String, content: String) extends Message {
  override def toString() = {
    s"$severity: $content"
  }
}

case class Debug(events: List[String], content: String) extends Message {
	override def toString() = {
    s"$content"
  }
}


def msg_format(msg: Any): String = {
  msg match {
    case Error(_,_) => "Error: " + msg;
    case Info(_) => "Info: " + msg;
    case Warn(_,_) => "Warn: " + msg;
    case Debug(events,_) => {
      if (events.size >= 2) "Debug: " + msg +  " with last event being: " + events(events.size - 1);
      else "Debug: " + msg;
    }
    case _ => "ERROR msg_format didn't match anything for " + msg;
  }
}

def debug_filter(msg: Debug): String = {
  msg.events match {
    case List("Initialization", _*) => msg.events.mkString(",");
    case head :: Nil => null;
    case _ => "ERROR debug_filter didn't match anything for " + msg.events.mkString(",");
  }
}

object Main {
  def main(Args: Array[String]) = {
    val error: Error = Error(System.currentTimeMillis(), "Foo")
    val info: Info = Info("More")
    val warn: Warn = Warn("Minor", "Bar")
    val debug: Debug = Debug(List("Initialization", "Bar", "FooBar"), "Some Events happened")
    val debug_short: Debug = Debug(List("Foo"), "Some Event happened")

    val mgs = List(Error(System.currentTimeMillis(), "Foo"), Info("More"), Warn("Minor", "Bar"), Debug(List("Initialization", "Bar", "FooBar"), "Some Events happened"), Debug(List("Foo"), "Some Event happened"))
    
    mgs.foreach(msg => println(s"msg_format($msg)= " + msg_format(msg)))
    
    println(s"debug_filter($debug)= " + debug_filter(debug));
    println(s"debug_filter($debug_short)= " + debug_filter(debug_short));
  }
}
### Dekorierte Logger
Logger helfen die Ausgaben von Programmen besser zu strukturieren. Statt einer einfachen Ausgabe über die Konsole mittels System.out.println(...) können so Ausgaben anhand ihrer Schwere deklariert werden. Bspw. kann eine Ausgabe über die Methode error(...) für schwere Fehler verwendet werden, während die Ausgabe über info(...) nur Info-Nachrichten beinhaltet. Typischerweise werden diese Nachrichten formatiert bspw. die Ausgabe via error("An error occured") führt zu der Ausgabe "ERROR: An Error occured" (Fehlermeldungen werden üblicherweise auch nicht per System.out.println ausgegeben sondern per System.err.println). Zusätzlich erlauben Logger basierend auf dieser Nachrichtenklassifizierung auch unterschiedliche Arten von Levels anzugeben, sodass nur die Nachrichten ausgegeben, deren Schweregrad gleich oder höher ist. Bspw. würde beim Logging-Level Info nur Nachrichten ausgeben werden, die über die Methoden info(), warning() und error() ausgegeben wurden. Dies hilft z.B. unnötige und störende Debug-Ausgaben bei der Ausgabe herauszufiltern.

Implementieren Sie einen ConsoleLogger und einen FileLogger, die das Logger Interface implementieren und Nachrichten unabhängig vom LogLevel ausgeben. Nutzen Sie String.format(...), um die Nachrichten mit dem gegebenen format-String und args zu formatieren. Der ConsoleLogger soll dabei Nachrichten auf der Kommandozeile ausgeben und der FileLogger die Nachrichten in eine Datei schreiben. Nutzen Sie zur Implementierung des FileLoggers den java.io.FileWriter. Vergessen Sie hierbei nicht, den Writer korrekt zu flushen!

Ergänzen Sie Ihre Logger jeweils um einen Konstruktor, der es erlaubt, die Logger per Decorator-Pattern zu dekorieren. Dabei soll ein Logger auf folgende Weisen erzeugt werden können:

```
Logger log1 = new ConsoleLogger(new FileLogger("log.txt"));
Logger log2 = new FileLogger("log.txt", new ConsoleLogger());
```
Implementieren Sie einen TimestampedLogger, der ebenfalls das Logger Interface implementiert und jeder Nachricht einen Zeitstempelpräfix hinzufügt. Nutzen Sie hierfür den DateTimeFormatter.ISO_LOCAL_DATE_TIME. Der TimestampedLogger soll ebenfalls als Decorator implementiert werden, um folgende Verwendung zu ermöglichen:

```
Logger log = new TimestampedLogger(new ConsoleLogger(new FileLogger("log.txt"));
log.info("Hello, world!"); // 2019-05-02T12:02:56.867 Hello, world!
```
Implementieren Sie nun einen LeveledLogger, der ebenfalls das Logger Interface implementiert und Nachrichten aufgrund eines LogLevels filtert. Dabei sollen nur Nachrichten an den dekorierten Logger weitergegeben werden können, deren Level schwerer oder gleich schwer dem konfiguriertem Level sind. Nutzen Sie hierfür level.compareTo nach der Definition aus dem Comparable Interface. Der LeveledLogger soll ebenfalls als Decorator implementiert werden, um folgende Verwendung zu ermöglichen:

```
Logger log = new LeveledLogger(LogLevel.Info, new TimestampedLogger(new ConsoleLogger(new FileLogger("log.txt")));
log.info("Hello, world!"); // 2019-05-02T12:03:25.519 [Info]: Hello, world!
log.warn("Some warning");  // 2019-05-02T12:03:25.678 [Warn]: Some warning
log.trace("This will be filtered");  // no output
```
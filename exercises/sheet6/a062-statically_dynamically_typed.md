### Statische vs. Dynamische Typisierung
In der Vorlesung wurden für Scala die implizite Typumwandlung und Typinferenz vorgestellt, welche sich aus der Typisierung der Programmiersprache ableiten.

Dazu sind folgende Fragestellungen zu recherchieren:

a. Was ist der Unterschied zwischen statischer und dynamischer Typisierung? Zeigen Sie diese (und ggf. Vor-/Nachteile) anhand eines kleinen Beispiels.

b. Was ist der Unterschied zwischen schwacher und starker (statischer) Typisierung? Zeigen Sie diese (und ggf. Vor-/Nachteile) anhand eines kleinen Beispiels.
---  
a)
- Statische Typisierung:
    - Der Typ von Variablen ist teil ihrer Deklaration. Damit steht er bereits zur Compilezeit fest.
    - Beispiel von statischer Typisierung einer Variablen in C++ oder Java: int x = 0;
    - Vorteil:
        - Der Compiler kann die Werte von Typen überprüfen und dadurch bereits viele Fehler in der Implementierung aufzeigen, wodurch letzlich viele Bugs früh erkannt und gefixt werden können.
        - Das ist umso hilfreicher und relevanter, je größer ein Softwaresytem ist, gerade wenn der Entwickler viel Code verwendet, den er nicht selbst geschrieben hat. Zum Beispiel bei der Verwendung von Bibliotheken. Für kurze, einfache Programme bietet das nur kaum einen Vorteil und benötigt nur zusätztlichen Aufwand und syntaktische Elemente.
- Dynamische Typisierung:
    - Variablen wird kein Typ konkret festgelegt, er wird zur Laufzeit dynamisch ermittelt und kann dadurch auch je nach Programmablauf unterschiedlich sein.
    - Beispiel von dynamischer Typisierung in Scala oder JavaScript: var x = 0;
    - Vorteil: 
        - Höhere Flexibilität: Aus einer Methoden können Werte verschiedener Typen zurückgegeben werden.
        - Einfacher zu verstehen. Gerade für Programmieranfänger.
        - Besser für kurze, simple Programme.
b)
- Schwache und starke Typisierung ist eine Klassifizierung von Programmiersprachen daran wie strikt der Compiler Typsicherheit und Typchecking forciert.
- Die Begriffe sind allerdings nicht klar definiert und abgegrenzt. Es handelt sich dabei eher um ein Spektrum zwischen den verschiedenen Sprachen.
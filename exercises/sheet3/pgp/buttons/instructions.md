## PGP Buttons
In der Klasse PGPFrame wird ein Fenster erzeugt, in dem mittels der Methode `addNewButton(PGPButton)` neue Buttons vom Typ `PGPButton` auf dem Frame erzeugt werden können. Diese PGPButtons definieren mittels der `click()-Methode die jeweilige Aktion, die nach dem Klicken des Buttons durchgeführt werden soll.

In der jetzigen Implementierung von PGPButton wird lediglich eine Konsolennachricht "Button was clicked" ausgegeben. Erweitern Sie das Verhalten mittels neuer Klassen, die von der Klasse PGPButton erben. Hierbei soll das Verhalten durch das Überschreiben der Methode click() erweitert werden.

Implementieren Sie:  
- Eine Klasse RecolorPGPButton, die nach jedem Klick die Hintergrundfarbe des Buttons zufällig ändert
- Eine Klasse PrintPositionPGPButton, die nach jedem Klick die Position des Buttons auf dem Frame auf der Konsole ausgibt
- Eine Klasse PrintClickHistoryPGPButton, die zu jedem Klick für diesen Button einen Zeitstempel in einer Liste speichert und diese Liste auf der Konsole ausgibt.
Beachten Sie jeweils die Einhaltung des Substitutionsprinzips nach Liskov.

Das Ergebnis kann dann folgendermaßen aussehen:  
siehe a034-pgp_buttons_result_example.png



Hinweis: Die Klasse PGPFrame erweitert die Klasse JButton (siehe API-Dokumentation). Das Setzen der Hintergrundfarbe bzw. das Bestimmen der Position ist somit mit den gleichen Methoden möglich wie bei der Klasse JButton. Für Zusatzfunktionen, wie zufällige Farben bestimmen oder Zeitstempel erstellen, kann gerne auf Hilfsklassen zurückgegriffen werden z.B. Color, Random oder Timestamp.
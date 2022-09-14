### Speedup
Ein Team von Studierenden der FIN hat einen bestehenden Algorithmus parallelisiert und möchte nun sowohl den Speedup als auch die Eﬃzienz dieses Algorithmus prüfen lassen. Dazu wurden die Laufzeiten mit unterschiedlichen Prozessoren gemessen (siehe nachfolgende Tabelle).

|Anzahl Prozessoren | 1 | 2 | 4 | 8 | 16 |
|---|---|---|---|---|---|
|Laufzeit $T(p) in s| 1024 | 850 | 787 | 740 | 720 |

Berechnen Sie jeweils den Speedup und die Eﬃzienz mit den realen Werten und nach dem Amdahlschen Gesetz. Gehen Sie davon aus, dass ca. 50% des Programms parallelisiert wurden. Geben Sie dabei auch die Berechnungsvorschriften mit an.
Vergleichen Sie die Werte! Was könnten die Ursachen für die unterschiedlichen Ergebnisse sein?

|Anzahl Prozessoren                     | 1     | 2     | 4     | 8     | 16    |
|---                                    |---    |---    |---    |---    |---    |
|Laufzeit $T(p) in s                    | 1024  | 850   | 787   | 740   | 720   |
|Speedup der realen Werte               | 1,000 | 1,205 | 1,301 | 1,384 | 1,42  | 
|Speedup gemäß dem Amdahlschen Gesetz   | 1,000 | 1,333 | 1,600 | 1,777 | 1,882 |

Gründe für die unterschiedlichen Ergebnisse:
- Das Amdahlsche Gesetz berücksichtigt keine Wartezeiten von Prozessen/Threads auf andere. Möglicherweise besteht beim Zusammenfügen des Ergebnisses Wartezeiten.
- Wenn auf einem realen Computer getestet wurde, laufen noch andere Prozesse, die das Betriebssystem möglicherweise zwischendrin ausgeführt hat, da diese eine höhrere Priorität als das zu testende Programm besitzen.
- Möglicherweise wird die Rechenlast nicht gleichmßig auf die gestarten Threads aufgeteilt, sodass einer länger braucht als die anderen und somit die Ausführungszeit verlängert.
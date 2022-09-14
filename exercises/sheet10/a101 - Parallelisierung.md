### Parallelisierung
“Durch Verdopplung der Prozessoren kann die Laufzeit halbiert werden.”
Nehmen Sie begründet Stellung zu dieser Aussage!

---
Diese Aussage ist so pauschal nicht richtig.
Durch die Verwendung von mehr Prozessoren um ein Programm auszuführen, kann sich die Laufzeit verringern - eine genaue Halbierung der Laufzeit bei Verdoppelung der Prozessoren ist aber sehr unrealistisch, vor allem wenn die Anzahl der bereits verwendeten Prozessoren bereits hoch ist.
Gründe dafür sind:
- Der sequentielle Anteil eines Programms profitiert nicht von mehr Prozessoren. Je größer dieser ist, desto wengier bringt die Verwendung von mehr Prozessoren.
- Parallelisierung bringt immer einen Overhead für das Erstellen und die Koordination der Prozesse. Wenn man die Anzahl der Prozesse ver n-facht, kann die Laufzeit dadurch nie exakt ein n-tel der vorherigen betragen.
- Ein Programm kann immer nur eine gewisse Anzahl an Prozessoren effektiv nutzen. Mehr Prozessoren führen gemäß Amdahls Gesetz zu immer weniger Speedup. Das liegt an der maximalen Anzahl an Subprozessen und Threads die das Programm verwendet.
- Je mehr Prozesse/Threads von einem Programm verwendet werden, desto höher wird die Wahrscheinlichkeit, dass diese auf einen anderen Warten müssen, da dieser ein Ergebnis berechnet, dass sie zur Berechnung benötigen oder gerade auf Daten zugreift, auf die jeweils nur einzeln zugegriffen werden darf und er diese deshalb gerade für sich beansprucht hat.
- Ein Programm kann theoretisch auch mit vielen Prozessoren und vielen Prozessen sehr ineffizient implementiert sein. Es wäre beispielsweise denkbar ein Programm zu schreiben, dass für jeden vorhandenen Prozessor einen Thread startet und diesen unendlich laufen lässt. In diesem Fall würden mehr Prozessoren zu überhaupt keiner Verkürzung der Laufzeit führen.
- Bei einer sehr großen Anzahl an verwendeten Prozessoren,übersteigt der Overhead der Parallelisierung den Benefit der Laufzeitverringerung oder die Laufzeit kann durch mehr Prozessoren gar nicht mehr verringert werden, dann sinkt der Speedup sogar.

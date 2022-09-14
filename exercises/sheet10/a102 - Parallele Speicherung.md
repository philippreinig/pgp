### Parallele Speicherung
Erläutern sie kurz an einem aussagekräftigen Beispiel die drei Formen der parallelen Speicherung.

---
1. Shared Memory:
    - Alle Prozessoren verwenden den gleichen Speicherbereich. Dazu müssen die Zugriffe entsprechend Koordiniert werden, damit nicht zeitgleich die gleichen Daten verändert werden oder während ein Prozess Daten verändert, diese von einem anderen gelesen werden. Das würde zu falschen / inkonsistenten Daten und Ergebnissen führen.
    - Der Mechanismus zur Koordination ist Multithreading.
    - Shared Memory wird bei der klassischen Multi-Core Architektur eingesetzt.
2. Distributed Memory:
    - Alle Prozessoren verwenden jeweils eigene, disjunkte Speicherbereiche. Dadurch müssen die Zugriffe nicht koordiniert werden. Der Speicher wird aber potentiell ineffizienter genutzt, wenn ein Prozessor sehr viel Speicher für seine Berechnungen benötigt oder mehr als ihm zur Verfügung steht und ein anderer seinen zugewissenen Speicherbereich gar nicht vollständig benötigt.
    - Der Mechanismus zur Koordination ist Message Passing.
    - Distributed Memory wird im klassischen Cloud-Computing eingesetzt.
3. Hybridform
    - Es ist eine Hybridform aus Shared und Distributed Memory möglich. Dabei werden Speicherbereiche in einem Knoten zusammengefasst. Innerhalb dieses Knotens wird per Shared Memory auf den Speicher zugegriffen. Zwischen den Knoten wird der Distributed Memory Mechanismus angewandt.
    - Diese Hybridform wird auf Rechenclustern angewandt.
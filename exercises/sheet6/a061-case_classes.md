### Scala Case Classes
In der Vorlesung haben Sie mit Scalas class- und object-Konstrukt zwei Möglichkeiten der Implementierung von Klassen kennengelernt. Eine weitere Variante sind case classes, die bei der Umsetzung des funktionalen Paradigmas hilfreich sind. Recherchieren Sie, was case classes sind und welchen Nutzen sie haben. Erläutern Sie dabei den Nutzen an einem kleinen Beispiel.
--- 
Case Classes in Scala sind quasi spezielle Klassen, die aufgrund deren Eigenschaften vor allem dafür gedacht sind um Daten zu halten und auf diese Zugriff zu gewähren, nicht aber sie nach dem initalen Erstellen zu ändern.
- Per Default sind alle Attribute val's nicht var's und var's sollten nicht definiert werden
- Die apply und unapply Methoden werden automatisch vom Compiler generiert
- Die toString(), equals() und hashCode() Methoden werden vom Compiler automatisch generiert  
Aufgrund ihrer Eigenschaften und besonders der automatisch generierten unapply Methode, eignen sich Case Classes in Scala besonders gut für Pattern Matching.
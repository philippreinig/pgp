### Generische Verkettete Listen
Verkettete Listen sind eine häufig genutzte Datenstruktur. Sie bestehen aus Knoten-Objekten, welche jeweils ein Element und eine Referenz auf den Nachfolgeknoten (sofern dieser existiert) enthalten.

1. Implementieren Sie eine generische verkettete Liste LinkedNode, die alle Datentypen, die das Interface `Comparable` implementieren enthalten kann, unterstützt. Passen Sie dazu die generische Definition in der Vorlage derart an, dass die Elemente das Interface `Comparable` verwenden.

2. Implementieren Sie die Methode `public void insert(E item)`, um beliebige Daten in sortierter Reihenfolge in die verkettete Liste einzufügen. Duplikate sollen hier ausdrücklich erlaubt sein.

3. Implementieren Sie die Methode `public boolean contains(E item)`, die true zurückgibt, wenn das Element item in der Liste enthalten ist bzw. false, wenn es nicht enthalten ist.

4. Implementieren Sie die Methode `public String toString()`, welche alle Daten in der Liste als String zurückgibt. Wie die Daten innerhalb des String getrennt werden ist dabei Ihnen selbst überlassen.

5. Implementieren Sie die Methode `public int getLength()`, welche die Länge der Liste (also die Anzahl der Knoten) zurückgibt.
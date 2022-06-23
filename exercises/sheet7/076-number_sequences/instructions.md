### Zahlenfolgen
Implementieren Sie die nachfolgenden Zahlenfolgen als Streams nach dem funktionalen Paradigma (keine Schleifen, Seiteneffekte vermeiden, etc.):

1. Abstandszahlen:  
    In dieser Zahlenfolge nehmen die Abstände zwischen den Zahlen bei jedem Element um zu. f(x) = {1 for x = 0, f(x-1) + x for x > 0}  
    Beispiel: 1,2,4,7,11,16  
    Hilfreiche Methoden: scan  

2. Schreiben Sie eine Funktion, die einen Stream von Primzahlen erzeugt.
    Hilfreiche Methoden: filter, range, forall, exists  

3. Mangoldt-Exponential-Funktion:
    Sie können den gcd aus der Codevorlage zum Erzeugen des kleinsten gemeinsamen Vielfachen verwenden.  
    Hilfreiche Methoden: fold, gcd, range, map  

Hinweis: Sie können Stream.from verwenden, um einen endlosen Stream zu erzeugen.  
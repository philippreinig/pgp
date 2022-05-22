/**
### Primzahlen und Gemeinsamer Teiler
Zwei natürliche Zahlen heißen teilerfremd, wenn es keine natürliche Zahl außer der 1 gibt, die beide Zahlen teilt. Das heißt, dass der größte gemeinsame Teiler zweier teilerfremder natürlicher Zahlen a und b ist.

Programmieren Sie unter der Beachtung des Funktionalen Programmierparadigmas (keine Schleifen, keine Seiteneffekte (Ausnahme: Ausgabe auf der Konsole), keine Abhängigkeiten vom Kontext) folgende Funktionen:

1.  Schreiben Sie eine Funktion gcd(a:Int, b:Int), die den größten gemeinsamen Teiler von a und b berechnet.
2.  Schreiben Sie aufbauend auf Ihrer Implementierung eine rekursive Funktion relativePrimes(n:Int), die alle Zahlen kleiner n ausgibt, die zu n teilerfremd sind.
    Sie können dazu auch notwendige Hilfsfunktionen implementieren.
*/


object Numbers{

    // 1)

    def gcd_rec(a: Int, b: Int) : Int = {
        if (b == 0) a
        else gcd_rec(b, (a % b))
    }

    def gcd(a: Int, b: Int) : Int = {
        var R = 0;
        var x = a;
        var y = b;
        while((x % y) > 0){
             R = x % y;
             x = y;
             y = R;
        }
        y
    }

    // 2)

    def relativePrimes(n: Int) : Unit = {
        print("relativePrimes(" + n + "):")
        for(i <- 1 to n){
            if(gcd(i,n) == 1) print(i + ",")
        }
        println()
    }

    def relativePrimesRec(n: Int) : Unit = {
        relativePrimesRec(n, 1)
    }

    def relativePrimesRec(n: Int, i : Int) : Unit = {
        if (i <= n){
            if(gcd(i,n) == 1) println(i)
            relativePrimesRec(n, i+1)
        }
    }

    def main(args: Array[String]) : Unit = {
        println(gcd(5,10), gcd_rec(5,10))
        println(gcd(27,9), gcd_rec(27,9))
        println(gcd(4,12), gcd_rec(4,12))
        println(gcd(1220, 516), gcd_rec(1220, 516))

        relativePrimes(10)
        relativePrimes(15)
        relativePrimes(21)

        println("relativePrimesRec(10):")
        relativePrimesRec(10)
        println("relativePrimesRec(15):")
        relativePrimesRec(15)
        println("relativePrimesRec(21):")
        relativePrimesRec(21)
    }
}

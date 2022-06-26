/**
### Currying
Currying ist das Darstellen einer Funktion mit n Parametern als eine Menge von  Aufrufen von einstelligen Funktionen. Lösen Sie die folgenden Aufgaben in der Programmiersprache Scala.

1. Definieren Sie eine explizite Currying-Funktion concatThree, die jeweils drei Strings miteinander konkateniert. Die Nutzung der Hilfsmethode curried ist nicht gestattet!

2. Implementieren Sie drei Funktionen preF, postFix und preAndPostfix, die durch gezielte Unterversorgung bzw. Festlegung der Werte der concatThree-Funktion definiert werden.
   Alle drei Funktionen sind parameterlos (nullstellig) und geben folgende Werte zurück:
    - preFi gibt eine Funktion zurück, die einen String pre und einen String txt entgegennimmt und vor den Anfang von txt den Inhalt von pre anfügt.
    - postFix gibt eine Funktion zurück, die einen String post und einen String txt entgegennimmt und nach dem Ende von txt den Inhalt von post anfügt.
    - preAndPostfix gibt eine Funktion zurück, die einen String txt entgegennimmt und >>> vor und <<< nach txt anfügt.
*/

object Currying{

    // 1)
    def concatThree(a: String)(b: String)(c: String) : String = {
        return a + b + c;
    }

    // 2)
    def preFix() : (txt : String, pre: String) => String = {
        return (a: String, b: String) => b+a;
    }

    def postFix() : (txt: String, post: String) => String = {
        return (a: String, b: String) => a+b;
    }

    def preAndPostfix() : (txt: String, pre: String, post: String) => String = {
        return (a: String, b: String, c: String) => postFix()(preFix()(a, b), c);
    }

    def main(args: Array[String]) : Unit = {
        val pre = "pre";
        val post = "post";
        val txt = "txt";

        var a = "a";
        val b = "b";
        val c = "c";
        println(s"concatThree($a)($b)($c)= " + concatThree(a)(b)(c));
        println(s"preFix()($txt, $pre)= " + preFix()(txt, pre));
        println(s"postFix()($txt, $post)= " + postFix()(txt, post));
        println(s"preAndPostFix()($txt, $pre, $post)= "  + preAndPostfix()(txt, pre, post));

    }
}
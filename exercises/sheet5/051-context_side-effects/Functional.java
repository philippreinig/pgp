class NonFunctional {
    public static final int BIN = 0;
    public static final int OCT = 1;
    public static final int DEC = 2;
    public static final int HEX = 3;

    private static int codec = DEC;
    private static int number = 0;
 
    public static void setNumber(int newNumber){
        number = newNumber;
    }

    public static void printNumber(){
        printNumber(number);
    }

    private static void printNumber(int printNumber){
        switch(codec){
            case BIN:
                System.out.format("0b%s\n", Integer.toBinaryString(printNumber));
                return;
            case OCT:
                System.out.format("0o%s\n",Integer.toOctalString(printNumber));
                return;
            case DEC:
                System.out.format("%d\n",printNumber);
                return;
            case HEX:
                System.out.format("0x%s\n",Integer.toHexString(printNumber));
                return;
            default:
                System.err.format("unknown codec '%d'\n",codec);
        }
    }

    public static void setCodec(int newCodec){
        codec = newCodec;
    }
}


public class Functional {

    public static int bin(){
        return 0;
    }

    public static final int oct(){
        return 1;
    }

    public static int dec(){
        return 2;
    }

    public static int hex(){
        return 3;
    }

    public static void printNumber(int printNumber, int codec){
        if(codec == bin()) System.out.format("0b%s\n", Integer.toBinaryString(printNumber));
        else if (codec == oct()) System.out.format("0o%s\n",Integer.toOctalString(printNumber));
        else if (codec == dec()) System.out.format("%d\n",printNumber);
        else if (codec ==  hex()) System.out.format("0x%s\n",Integer.toHexString(printNumber));
        else System.err.format("unknown codec '%d'\n",codec);
    }

    public static void main(String[] args){

        System.out.println("Non functional: ");
        NonFunctional.printNumber();
        NonFunctional.setNumber(1337);
        NonFunctional.setCodec(NonFunctional.BIN);
        NonFunctional.printNumber();
        NonFunctional.setCodec(NonFunctional.OCT);
        NonFunctional.printNumber();
        NonFunctional.setCodec(NonFunctional.DEC);
        NonFunctional.printNumber();
        NonFunctional.setCodec(NonFunctional.HEX);
        NonFunctional.printNumber();
        
        System.out.println("---");
        
        System.out.println("Functional:");
        Functional.printNumber(0, Functional.dec());
        Functional.printNumber(1337, Functional.bin());
        Functional.printNumber(1337, Functional.oct());
        Functional.printNumber(1337, Functional.dec());
        Functional.printNumber(1337, Functional.hex());
    }
}
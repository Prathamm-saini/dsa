package basics.strings;

public class preetyPrinting {
    public static void main(String[] args) {
        // printf
        ///  %d for int , %s for string, %f for float,%t for date and time , % o for octal
        double a  = 423.1111f;
        System.out.printf("Formatted Output is %f",a);
        System.out.println();
        String name = "Pratham";
        int  age = 21;
        System.out.printf("Hello my name is %s and age is %s",name,age);
    }
}

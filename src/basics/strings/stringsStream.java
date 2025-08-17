package basics.strings;

import java.util.Arrays;

/// More features of strings
/// question : when we pass multiple objects or make them how do they get printed in java?
/// when we do System.out.println() , here out is a variable of type print stream
/// PrintStream is a class with method println(),printf() and print()

public class stringsStream {
    public static void main(String[] args) {
        //PrintStream class has different println functions all are overloaded / with different signatures
        // some take strings as input, some take int as input , some take objects and some take null etc
        System.out.println(56);
        // here it calls valueOf which further calls .toString() method
        // its like gimme whatever it will convert it into strings and print it
        // .toString calls getclass() getname() and @ + hashcode() functions random values gets printed
        System.out.println(new Integer(56).toString());
        System.out.println("Prat");
        System.out.println(new int[]{1, 2, 3, 4});
        // here by default toString() is called so it will show object

        // here we explicitly make it run toString() of arrays
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4}));

        String name = null;
        System.out.println(name);
    }
}

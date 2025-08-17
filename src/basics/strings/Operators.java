package basics.strings;

import basics.array.Arraylist;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a'+'b'); // adding with ascii value
        System.out.println("a"+"b"); // prints string ab
        // with strings takes string only
        System.out.println('a'+3); // char converted to ascii value
        System.out.println((char)('a'+3));

        // note string + int -> int will be converted to Integer, and it will call toString method
        System.out.println("a"+3); // a3 -> "a" + "3"

        System.out.println("Pratham"+new ArrayList<>());

        System.out.println(1+2+3+"p"); // add 1+2+3 = 6 converts into string "6" + "p" gets concatenated
        System.out.println("p"+1+2+3); // "p" +"1"+"2"+"3 all gets concatenated

        // operator - works on char , not in strings same for * and /
        // here it's not allowed to improve performance and remove bad code


        /// what is happening here?
        /// "a" +"b" -. creats a new object "ab" and "a" and "b" will be removed by gc


    }
}

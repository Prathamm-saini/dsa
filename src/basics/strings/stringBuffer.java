package basics.strings;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
/*
StringBuffer is a class in java
It is a mutable sequence of characters

Advantages
1.Mutable
StringBuffer sb = new StringBuffer();
sb in stack pointing to objc( here it's null) in the heap memory (they are not created in string pool)
2.Highly efficient in CP and in general
3. Thread Safe (lightweight process)
let's say thread t1 and t2 both working on same data and value gets changed via some thread.
thread safety is simply, when one thread only does it's work when one stops working on it

So string buffer is thread safe and only one thread works at a time on string buffer
this also makes it slower as only 1 thread works on it at a time

StringBuilder vs StringBuffer
StringBuilder is not thread safe that's the only difference



*/

public class stringBuffer {
    public static void main(String[] args) {
        // Constructor 1 with capacity 16
        StringBuffer sb = new StringBuffer();
        sb.append("Hello ");
        sb.append("World");
        System.out.println(sb);

        /// Constructor 2
        StringBuffer sb2 = new StringBuffer("Pratham");
        /// Constructor 3
        StringBuffer sb3 = new StringBuffer(30);// 30 is initial capacity of length of string buffer

        sb.insert(11," Pratham");
        System.out.println(sb);

        sb.replace(6,12,"Mr. ");
        System.out.println(sb);

        System.out.println(sb.reverse());

        System.out.println(sb.capacity()); // initially it was 16 now changed
        System.out.println(sb2.capacity());


        // How can we create a random string?
        Random rand = new Random();
        System.out.println(rand.nextInt()); // for random number generator for integer
        System.out.println(rand.nextFloat()); // for random number generator for float

        // for strings
        for (int i = 0; i <26; i++) {
            int randomChar = 97 + (int) (rand.nextFloat()*26);
            sb3.append((char)randomChar);
        }
        System.out.println(sb3);

        // split
        String sent = "Kobe   Bryant";
        String[] names = sent.split(" ");
        System.out.println(Arrays.toString(names));


        // remove whitespaces
        String sentence = "My name is Pratham";
        System.out.println(Arrays.toString(sentence.split("")));
        System.out.println(sentence.replace("/s", ""));


        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(7.8));
    }
}

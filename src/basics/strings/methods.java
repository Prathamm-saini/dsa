package basics.strings;

public class methods {
    public static void main(String[] args) {
        String s = "hello";

        // 🔹 Length & Access
        System.out.println(s.length());                 // 5
        System.out.println(s.charAt(1));                // 'e'
        System.out.println(s.codePointAt(1));           // 101 (Unicode of 'e')

        // 🔹 Substrings
        System.out.println(s.substring(2));             // "llo"
        System.out.println(s.substring(1, 4));          // "ell"

        // 🔹 Searching
        System.out.println(s.indexOf('l'));             // 2
        System.out.println(s.indexOf("ll"));            // 2
        System.out.println(s.lastIndexOf('l'));         // 3
        System.out.println(s.contains("he"));           // true
        System.out.println(s.startsWith("he"));         // true
        System.out.println(s.endsWith("lo"));           // true

        // 🔹 Comparison
        System.out.println(s.equals("hello"));          // true
        System.out.println(s.equalsIgnoreCase("HELLO"));// true
        System.out.println(s.compareTo("apple"));       // >0 (since "hello" > "apple")

        // 🔹 Modification
        System.out.println(s.concat(" world"));         // "hello world"
        System.out.println(s.replace("l", "x"));        // "hexxo"
        System.out.println(s.replace('l', 'y'));        // "heyyo"
        System.out.println("a1b2c3".replaceAll("[0-9]","")); // "abc"
        System.out.println(s.toLowerCase());            // "hello"
        System.out.println(s.toUpperCase());            // "HELLO"
        System.out.println("   hi   ".trim());          // "hi"

        // 🔹 Splitting & Joining
        String[] arr = "a b c".split(" ");              // ["a","b","c"]
        System.out.println(String.join("-", arr));      // "a-b-c"

        // 🔹 Conversion
        char[] chars = s.toCharArray();                 // ['h','e','l','l','o']
        System.out.println(String.valueOf(123));        // "123"
        System.out.println(Integer.parseInt("123"));    // 123
        System.out.println(Long.parseLong("12345"));    // 12345

        // 🔹 StringBuilder (mutable strings, very important in CP)
        StringBuilder sb = new StringBuilder(s);
        sb.append("abc");                               // "helloabc"
        sb.insert(2, "x");                              // "hexlloabc"
        sb.delete(1, 3);                                // deletes [1,3) → "hlloabc"
        sb.reverse();                                   // reverse → "cbaollh"
        System.out.println(sb.toString());              // final result
    }
}

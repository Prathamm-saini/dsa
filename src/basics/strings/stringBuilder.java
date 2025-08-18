package basics.strings;

public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("World");
        System.out.println(sb);

        // Similar just are mutable as well created in heap
        // there is no con concept of string pool in string builders
    }
}

package basics.strings;
// WHY DO WE NEED STRING BUILDER
public class Performance {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i <26; i++) {
            char ch = (char) ('a'+i);
            System.out.print(ch+" ");
        }
        System.out.println();
        String ser= "";
        for (int i = 0; i <26; i++) {
            char ch = (char) ('a'+i);
            ser += ch;
        }
        System.out.println(ser);
    }

    // problem here ? not a great solution
    ///  after first iteration -> ""+"a" -> "a"
    /// after 2nd iteration -> "a" +"b" -> "ab"
    ///  same happens again and again
    /// all string created in pool will be gone as new one will be created each time the loop runs
    ///  wastage of space is the issue here
    ///  time complexity o(n square) // string of size 1 +2 +3 +4.....+ N = N(N+1)/2 -> N square

    ///  so for adding in string a lot of space is wasted and gc has to work hard
    ///  so strings modification  if forced is not a good idea by typecasting etc


    ///  VIABLE SOLUTION IS STRING BUILDER FOR THIS
    ///  IN STRING BUILDER WE CREATE A SINGLE OBJECT AND ADD IT
    ///  so string builder do not create a new string each time
    /// it will be like sb ="abc" then adding d will be modifying sb, and it will be "abcd"
    ///  so  no abc is lost in this procedure and a new memory space created and neither gc has to work hard
}

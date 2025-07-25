package basics.strings;

import java.util.Scanner;

public class strings {
    public static void main(String[] args) {
        System.out.println("Strings");
        // string creation using objects
        String name = "";
        name = "Glen";
        System.out.println("Name is: " + name);
        // strings are created in heap memory inside string pool
        // when we reassign a variable, it checks in string pool whether that element is present or not
        // if not present it created that object/ value and point the variable to that in memory
        // that's how in java strings property of immutability holds true
        // strings cannot be changed/ modified but can be deleted using garbage collector
        // when you create strings using objects and new keyword it gets stored in heap memory and string bool both
        String isLoggedIn = new String("YES");
        // isLoggedIn is created in both pool and heap. it first points to heap which further checks its validity using pool

        // case two
        String name1 = new String("Prat");
        String name2 = new String("Prat");
        // here name1 points to Prat stored in heap as well Prat is created in heap memory to check validity
        // name2 has same value too. but it creates another Prat in memory (heap) but as Prat is present already in pool
        // it doesn't create another in string pool and points to newly made Prat object in heap memory for name2
        // all this coz of new keyword

        // interview question
        String abc = new String("abc");
        // how many strings are created here?
        // answer is maybe 1 or 2 ! huh?
        // explanation -> if abc already exists new object is created in heap memory no need to create in pool memory as it already exists
        // if it doesn't exist's two objects are created one in heap and another in string pool

        // for string comparison use str1.equals(str2) operator instead of == as == compares references instead of value
        // in strings you know  for all var even holding same value diff references are created at heap

        System.out.println(name1.equals(name2)); // returns true/false

        // string input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.next();// takes until _ is encountered
        input.nextLine(); // consumes the left over
        // so it's a key here whenever using nextLine after next() it
        // moves past and assign the leftover i-e "saini" to sentence
        // to solve this classic java problem use nextLine() after finishing next()
        System.out.println(word);
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine(); // take full sentence till keyboard input is taken
        System.out.println(sentence);

        // we have multiple functions for strings like .lowercase(),uppercase() etc
        // remember string is immutable so these function doesn't change the actual value rather create another string in pool
        // and returns the desired results
        String college = "University School of Automation and Robotics";
        college = college.toUpperCase(); // now college will point to diff string having same content just uppercase
        System.out.println(college); // same goes for lowercase etc

        // charAt(index) -> returns character at a particular index
        System.out.println(college.charAt(8)); // takes index pos returns character
        // search occurrence/index
        System.out.println(college.indexOf('A')); // take char gives index returns first index where it is present
        System.out.println(college.lastIndexOf('A'));

        // length of string
        System.out.println(college.length());

        // iterating a string
        char[] ch =  college.toCharArray();
        for (int i = 0; i <ch.length; i++) {
            System.out.print(ch[i]+" ");
        }
        System.out.println();
        // .compareTo operator
        System.out.println("Pratham".compareTo("Prat")); // returns 3
        System.out.println("Prat".compareTo("Pratham")); // returns -3
        System.out.println("Pratam".compareTo("Pratam")); // returns 0
        System.out.println("saiyam".compareTo("Pratham"));
        // for this case as the initial letter is different itself and
        // no string hits end of line. it finds uni-code value of 1st and 2nd subtract them and returns the value

        // it checks character by character for ex pratham is matched with prat , p r a t is matched but h a'' m is left out
        // so it returns 3 in that case.
        // Prat. compareTo(Pratham) -> 3 character are still unmatched but now its ordered 2nd so
        // result will be -3

        // trim function
        System.out.println("   Glenn     ".trim());
        System.out.println("Glen Maxwell".startsWith("Glen"));
        // startsWith checks for same prefix and returns true/false
        System.out.println("Glen Maxwell".endsWith("well"));
        // checks for suffix if same value from any ending point returns true


        // sub-string (contiguous part of a string )
        System.out.println("Pop-aye".substring(0,3)); // end index is exclusive
        // takes beginning index and end index create a new string in string pool
        // though here we are just printing it so it no one's pointing to it, it gets cleared by gc
        // we can have another substring method with only beg index

        String myLocation = "Delhi,Mumbai,Pune,Bangalore,Chennai";
        String[] myLocationList = myLocation.split(",");
        // regex -> regular expression
        for (int i = 0; i < myLocationList.length; i++) {
            System.out.print(myLocationList[i]+" ");
        }
        System.out.println();

        // interview question
        String email = "prathamzxc@gmail.com";
        String emailTwo = "pratham@hotmail.com";
        // extract the company name after @ i-e email and hotmail
        String[] emailArr = email.split("@");
        String companyName = emailArr[emailArr.length-1];
        // can be done with this
        //System.out.println(Arrays.toString(companyName.split(".com")));
        // or below one too works
        int dotIndex = companyName.lastIndexOf(".");
        System.out.println("Company name is: " + companyName.substring(0, dotIndex));
        // one other method can be find last index of @(say a) and .(say b) as email is between them then iterate
        // from a+1 to b ( b is exclusive so no b-1)

        // string is immutable, but we have a mutable version of string to
        // that's "StringBuilder"(unsafe in multithreaded env) and "StringBuffer"(safe in multithreading env)
        // both of them are stored right away in heap memory instead of string pool so can be editable
        // difference between them is of synchronization
        // let's say we have 3 threads( part of a process) working with a string (same) one wants to edit, one wants to print, one wants to delete
        // in synchronization one works other two gets locked which makes it safe
        // while in non synchronization all can work at same time making it unsafe

        StringBuilder bestSkill = new StringBuilder();
        bestSkill.append("Java");
        System.out.println(bestSkill);

        StringBuffer buffer = new StringBuffer();
        buffer.append("IIT-D");
        System.out.println(buffer);


        // Both of these string types i-e -> StringBuilder and StringBuffer are faster than Strings

        // note -> for input when you use next() its delimiter is whitespace
        // always remember it stops at empty space , so when you use nextLine() for it newline char "" is a delimiter
        // so it skips and doesn't take input if nextLine is used after Line i-e line() nextLine()
        // to bypass this use "sout after next(); so this consumes the newline char at the end of input of next()

        // concatenation -> interview
        System.out.println("SHA"+256);
        // it's a pattern string + Integer/double/byte/char/boolean -> string
        // 2nd pattern -> Int + Int + STRING -> integer will be added then + string -> converted to string same for double etc
        // string formatting
        double num = 99.876666;
        System.out.println(num);
        System.out.printf("Number is  %.2f",num);
        System.out.println();
        // using printf we can format string % t -> type, %f float, %d int, %s string,
        String enrollmentNumber = "08619051922";
        System.out.printf("Enrollment number is  %s and marks scored is %.2f",enrollmentNumber,num);


    }
}

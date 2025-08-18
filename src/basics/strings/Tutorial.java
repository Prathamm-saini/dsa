package basics.strings;
/// Strings are sequence of characters
/// It is a non-Primitive data type
///  if int a = 10; here an is reference variable in stack stored in stack itself as stack frame as
///  int is a primitive so only stored in stack
///  if int[] a = {1,2,3}; ref var 'a' in stack pointing to {1,2,3} in heap. as array is a non-primitive
///
/// similarly we have a data type known as String data type; String name = "pre";
/// Capital identifier is always a class in java
/// when we write String name = "Pratham Saini"
///  every string we create is object of String
///  name -> reference variable , Pratham Saini -> object
///
/// Question if we create two string a and b storing same value how will they behave in memory?
/// String a = "Pratham"
/// String b = "Pratham"
/// case 1 : both a and b in stack pointing to same object "Pratham" in heap
/// case 2 : both a and b in stack pointing to different object "Pratham" in  heap
///
///  to answer this we need to learn two Concepts String pool and Immutability
/// let's see how it actually happens and then why this happens.
///  if name = "Pratham"
///  name is in stack pointing to Pratham inside String pool which is inside Heap memory only
///  string pool is just another memory space inside heap
///
/// use case of string pool ?
/// all the similar values for strings are not re-created
/// so if o create b = "Pratham" -> it's like "Pratham" already exists in pool no need to recreate it
///
///  follow-up question?
/// in arrays if we point two ref var to one value , then change made via one ref variable is reflected on the other
///  ain't it dangerous? as they are pointing to same obj in heap
///
/// ans -> Nah it won't change, coz strings are immutable by nature
///  what will happen then? if one variable changes which initially pointed to same object in heap
///  a new string will be created in pool, and now it will be pointing to that
///
/// So Strings are Immutable
/// String a = "Prat"
/// a = "sai" // clearly work but strings are immutable then how?
/// look clearly!! we are not modifying a rather we are creating a new object in string pool which will now point to sai (object)
///
/// explanation
/// 1. String a = "Pratham"
/// here a ref var in stack points to "Pratham" in string pool inside heap
/// 2. a = "saini"
/// now  "saini" is created in string pool as it doesn't exist anyway and now a points to it
/// -> so here we are not modifying rather a new object is created here
/// (note -> Pratham will be removed by garbage collector automatically)
///
///  let's say
///  person 1
///  person 3
///  ...         all points to  "Maxwell"
///  person n
///  String are immutable so this case ain't possible ->
///  here if person 7th changes its name then all person's name will be changed ? nah, strings are immutable, it will create an object new one for person 7 and now it points to that
///
/// Comparison's of Strings
/// String a  = "Pratham"
/// String b = "Pratham"
///  we know "Pratham" is in pool and both a and b are pointing to same object "Pratham" but how do we prove?
///
///  if we do a === b , it will show true
///  == comparator operator will check for both of these values + reference (importantly here )
///   it will be false when a points to pratham and b points to different pratham in pool
///  ( *** doubt -> how is it even possible here as values are same
///    this case usually comes when we create string objects using new keyword)
///   it will be true if both values and references are same
///
/// ** when to create string objects using new keyword?
/// when you wants to explicitly tell java that you want a new object in heap to get created each time even though that value already exists in string pool
/// String a = new String("Pratham")
/// "Pratham" gets created in Heap memory. Point to be NOTED here -> not in string pool
///  *** STRING OBJECTS CREATED WITH NEW KEYWORD GETS STORED IN HEAP MEMORY NOT IN STRING POOL
/// though we must create string in string pool, not a good way
/// **
/// .equals() method
/// when you only need to check values use .equals method
/// string1.equals(string2); compares values
///
/// ** even though its contagious sequence of character we cannot access it using index like name[0] etc
///  we have a method for this
///
/// string.charAt(index); -> char at a index

public class Tutorial {
    public static void main(String[] args) {
        String name  = "Asta";
        System.out.println(name);

        String a = "Pratham";
        String b = "Pratham";
        System.out.println(a == b); // true

        String age  = new String("21");
        System.out.println(age);

        String age2 = new String("21");
        System.out.println(age2 == age); // false as objects created strings

        System.out.println(age.equals(age2)); //  true as it only compares value only

    }
}

package basics.hashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Hashing is a simple technique which use a key value pair, pass it to hash function and creates a hashcode
 this hashcode can be used in various ways like abstraction, security, data storage
ex -> 10(key) gets passed to a hash function Usually there are multiple hash functions (it helps in creating more unique codes)
hashcode is something like 124@hashcode(some code) (JVM does it)

real life use case-> we create an account on instagram -> create userid and password this gets stored on its server
for the user their data privacy is important. so companies like these may provide encryption but this is also hackable to some extent
so what companies do is Hashing.

Hashcode is very difficult to deal with i-e similar to how sha256 works (based on hashing only)
multiple hash functions make more unique hashcode

[closed hashing]
ex
search keys -> [11,10,66,58,74]
what is a hashtable? used to store key value pairs
* hash functions
1. Division method (mostly used) (using mod) (key mod size) size = 11 (ex we are using)
2. mid square method -> |mod [key square]| % size of hash table
3. folding method -> add digits then mod by size of hash table

let's use Division method (usually used)
key mode size
for key = 11 -> 11 mod 11 = 0 (store at index 0)
for key 10 -> 10 mod 11 = 10 (store at index 10)
for key 66 -> 66 mod 11 = 0 (store at index 0) -> collision here (there are different techniques to resolve it)
for index 58 -> 58 mod 11 = 0 (store at index 3)
for index 74 -> 74 mod 11 = 8 (store at index 8)

Hash table  [size = 11]
index 0 -> 11
index 1
index 2
index 3 -> 58
index 4
index 5
index 6
index 7
index 8 -> 74
index 9
index 10 -> 10

Collision resolution Technique
1. closed hashing -> if collision happens store that in the same table
here we use linear probing -> collision happens for key=66 we ant to insert it at index = 0
just see if the just next place is empty fill it there ie place it at 1 index

linear probing -> (h(x) + i) mod size of hash table
this 'i' increases depending upon index is filled so increment 1 if reach last which is already filled so start from 0 again

let's say whole hashtable is filled ,you wanted to  insert one more key
so you start and iterate whole hash table o(n) complexity which is bad
to negate that we use load factor(alpha notation)
alpha = e/m -> e-> no of element , m = size of hash table
if
 (0-1 value) -> alright table is good and values can be inserted
else
 double the size of hash table , this is called  re-hashing

 Two Drawbacks
1. Primary clustering
group formation for similar kind of elements
i-e for ex-> remainder 0,1,2,3 and even 10 we have all of them coming at same place and forming groups

problem in searching because of PC
probability of one element at a many index increase i-e on a cluster increases which creates confusion

2. Secondary clustering
two elements 77 and 87 both of them will have a same probing sequence i-e collision happens at similar index's

3. Deletion
bit tricky
search-> delete -> don't leave empty - add symbol here which shows something is deleted from here (helps in optimal searching)

3rd type of Probing
3.quadratic probing

h(x) + index square if collision add +1 in 'i'
creates gap between index's solves PC but do-not solve SC clustering


[open hashing]
separate chaining
rather storing data in hashtable store it in diff places
* we use linked list to store data at random places connect them at index

so at particular index we have diff elements at same index with nodes connectin to each other

worst case o(n) searching and delete
 */
public class hashmapIntro {
    public static void main(String[] args) {
        // roll no(key) -> name(value)
        // in hashmap insertion order is not maintained
        // time complexity for any operation in hashmap -> o(alpha) -> alpha is constant and called load factor
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Prat");
        map.put(2,"Sai");
        map.put(3,"Arrow");
        map.put(4,"Glenn");
        System.out.println(map); // outputs key value pairs
        System.out.println(map.get(1)); // fetches from index/key returns value
        // containsKey(key) -> returns boolean value tells whether key is present or not
        System.out.println(map.containsKey(1));

        // important function
        // returns value for a key, if key doesn't exist returns a default message/ value
        System.out.println(map.getOrDefault(5,"not present"));

        // for update
        map.replace(2,"Sai");

        // for iterating in maps
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println("Key is "+entry.getKey()+" Value is "+entry.getValue());
        }
        // using keySet() i-e accessing from a bunch of keys
        for(Integer key : map.keySet()){
            System.out.println("Key is "+key+" Value is "+map.get(key));
        }

        // custom hashmap

        HashMap<myCollegeId,myRanking> collegeRankingMap = new HashMap<>();
        collegeRankingMap.put(new myCollegeId(86),new myRanking(1));
        collegeRankingMap.put(new myCollegeId(87),new myRanking(2));
        collegeRankingMap.put(new myCollegeId(88),new myRanking(3));
        /* problem with new keyword here
        in initial hashmap you gave the key and accessed via the same key
        here you are creating a new object inside put function and when accessing using get making a new object
        even though value you think i-e 86 is same for both java assumes them as different entities coz of new keyword
        */
        System.out.println(collegeRankingMap.get(new myCollegeId(86)));
        System.out.println(collegeRankingMap); // this will return Hashcode not the value

        // important -> if you want to get real key value pairs
        // you would be required to override the hashCode method of object class
        // to check if reg no passed is same in function call as well we will override equals method

        // should return true but return false same reason, you cant say both values are equal acc to java
        // so you would need to override the .equals method in ranking class too to compare value(rank here) to equate both of them as equal
        System.out.println(collegeRankingMap.containsValue(new myRanking(1)));

    }
}

// creating custom hashmap
class myCollegeId{
    int registrationNumber;
    int hashCode;
    myCollegeId(int registrationNumber){
        this.registrationNumber = registrationNumber;
        this.hashCode = registrationNumber;
    }
    @Override
    public int hashCode() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object obj) {
        myCollegeId myCollegeId = (myCollegeId)obj;
        return myCollegeId.hashCode == hashCode;
    }


}
class myRanking{
    int rank;
    myRanking(int rank){
        this.rank = rank;
    }
    @Override
    public String toString() {
        return this.rank+"";
    }

    @Override
    public boolean equals(Object obj) {
        myRanking myRanking = (myRanking)obj;
        return myRanking.rank == this.rank;
    }
}

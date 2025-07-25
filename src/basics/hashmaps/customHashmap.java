package basics.hashmaps;

import java.util.LinkedList;
import java.util.Objects;

public class customHashmap<K,V> {
    class Node{
        K key ;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return key+":"+value;
        }
    }
    LinkedList<Node> hashTable[];
    // load factor threshold  is 0.75 for resizing
    private int elements;
    private int tableSize;
    private double threshold;

    private void initializeHashTable(){
        for (int i = 0; i <tableSize; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }
    public customHashmap(){
        tableSize = 16; // same in java implementation
        elements = 0;
        hashTable = new LinkedList[tableSize];
        threshold = 0.75;
        initializeHashTable();
    }

    // hash function
    private int getHashCode(K key){
        // Objects.hash generates hashcode we use this coz we don't know type of key
        int hashcode = Objects.hash(key);
        // hashcode can be very big
        hashcode = (Math.abs(hashcode)%tableSize);
        return hashcode;
    }
    private int searchKeyInList(K key,int hashcode){
        LinkedList<Node> list = hashTable[hashcode];
        for (int index = 0; index <list.size(); index++) {
            // find the index where key.equals = key passes
            if (list.get(index).key.equals(key)) {
                return index;
            }
        }
        return -1;
    }
    private void rehashing(){
        LinkedList<Node> oldTable[] = hashTable;
        tableSize = 2* tableSize;
        elements = 0;
        hashTable = new LinkedList[tableSize];
        initializeHashTable();
        for(LinkedList<Node> list : oldTable){
            for(Node node : list) {
                put(node.key,node.value);
            }

        }
    }
    public void put(K key,V value){
        // if key is not found it inserts, else update if changed
        // step 1 find the hashcode
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key,hashcode);
        Node newNode = new Node(key,value);
        if(index ==-1){
            // insert
            hashTable[hashcode].add(newNode);
            elements++;
        }
        else{
            hashTable[hashcode].get(index).value = newNode.value;
        }
        if(elements/(double)tableSize >= threshold){
            // if all spaces filled double the size of hashTable
            rehashing();
        }
    }
    public V get(K key){
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key,hashcode);
        if(index == -1){
            return null;
        }
        return hashTable[hashcode].get(index).value;
    }
    public void remove(K key){
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key,hashcode);
        if(index == -1){
            System.out.println("Invalid key");
            return;
        }
        hashTable[hashcode].remove(index);
        elements--;
    }
    public boolean contains(K key){
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key,hashcode);
        return index != -1;
    }
    public int size(){
        return elements;
    }
}

class implementation{
    public static void main(String[] args) {
        customHashmap<Integer,Integer> myMap= new customHashmap<>();
        myMap.put(1, 1);
        myMap.put(2, 2);
        System.out.println(myMap);

    }
}
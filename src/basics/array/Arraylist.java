package basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

///  ArrayList are dynamic arrays
/// internally arraylist is simply like arrays with default size if size exceeds we create a new array with double the size \
/// restore all older elements in new one and points the old one to new one again
/// Amortized time complexity is a method used in computer science to analyze the average time complexity of a sequence of operations on a data structure, particularly when some operations are significantly more expensive than others but occur infrequently.
///  Instead of focusing solely on the worst-case time complexity of a single operation, amortized analysis considers the total cost of a series of operations and divides it by the number of operations to find the average cost per operation.
///  This approach provides a more accurate and realistic measure of performance for algorithms where expensive operations are rare and their cost can be "spread out" or "amortized" over many cheaper operations.
///
/// A classic example is a dynamic array (like a vector or ArrayList), where inserting an element typically takes O(1) time. However, when the array is full and needs to be resized, a new, larger array is allocated (often double the size), and all existing elements are copied over, which takes O(n) time.
///  Although this resizing operation is expensive, it happens infrequently—specifically, only when the array size reaches a power of two. Because the array size doubles each time, the total cost of all resizing operations over a sequence of n insertions is bounded by a constant multiple of n.
///  Therefore, the amortized time complexity for each insertion is O(1), even though individual insertions can occasionally take O(n) time.
class DynamicArray{
    int DEFAULT_CAPACITY = 10;
    int[] data = new int[DEFAULT_CAPACITY];
    int index = -1;

    public void add(int element){
        if(index == data.length-1){
            int[] newData = new int[2*data.length];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        this.index++;
        data[index] = element;
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return index+1;
    }
    public int  remove(int indexToRemove){
        if(indexToRemove == -1){
            return -1;
        }
        int temp = data[indexToRemove];
        for(int i = indexToRemove; i < data.length-1; i++){
            data[i] = data[i+1];
        }
        this.index--;
        return  temp;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(data, 0, index + 1));
    }

}
public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> arraylist = new ArrayList<>();
        // we have to pass the wrapper classes in ArrayList
        arraylist.add(1);
        arraylist.add(2);

        arraylist.add(3);
        System.out.println(arraylist); // this arraylist will call toString internally4


        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.add(6);
        dynamicArray.add(7);
        dynamicArray.add(8);
        dynamicArray.add(9);
        dynamicArray.add(10);
        dynamicArray.add(11);
        dynamicArray.add(12);
        System.out.println(dynamicArray.get(0));
        System.out.println(dynamicArray);

        dynamicArray.remove(5);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.size());


        // Multi dimensional Arraylist
        ArrayList<ArrayList<Integer>> multi = new ArrayList<>();

        // initialization
        // creates 3 arraylist inside an arraylist
        for (int i = 0; i <3; i++) {
            multi.add(new ArrayList<>());
        }

        // input part
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                multi.get(i).add(scanner.nextInt());
            }
        }
        System.out.println(multi);
    }
}



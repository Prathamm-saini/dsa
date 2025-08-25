package basics.Recursion;
/// Question -> print something like "Hello World" 5 times again and again
/// way 1 -> in main write "System.out.println("Hello World");" 5 times
/// way 2 -> call a function which itself prints the no of times you want to print
///  for(int i -> n){sout("Hello world)}
/// way 3 -> create message1 fn which calls message2 in its body and similar functions to print accordingly
/// are these way's practical ? no, what if n>>>>> it violates DRY principle
///
/// better way ?
/// Recursion (when a function calls itself)
/// all the functions will have same body except arguments or even similar depending upon your way of recursion
///
/// memory is allocated differently for calls even though they are having the same body
///
/// Base condition
/// if no base condition fn will call itself infinitely and whole stack memory gets filled out and STACK OVERFLOW will happen
///
/// space complexity for recursion is o(n) n-> no of function calls
///
/// Understanding recursion is easy if you visualize it in a tree based fad
/// main gets onto stack
/// fn calls gets onto stack
/// this repeats
/// until base condition is violated
///
/// It follows a LIFO based fashion (Last In First OuT)
/// SO fn which violated the base condition returns and move to same point it was called
/// that is one place above and similarity each  fn moves out of stack
/// in the end main moves out of stack and function gets finished
public class intro {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        print(1);
        numberProgram(1);
        System.out.println();
        iterativeFibonacci(10);
        System.out.println();
        System.out.println(recursiveFibonacci(10));
        System.out.println(recursiveBinarySearch(array,8,0,array.length-1));
    }
    // Violates the DRY principle
    static void message(int n){
        for (int i = 0; i <n; i++) {
            System.out.println("Hello World");
        }
    }
    // Recursion when a fn calls itself
    static void print(int n){
        // Base condition
        if(n>5){
            return;
        }
        System.out.println("Hello World");
        print(++n);
    }
    static void numberProgram(int n){
        if(n>5){
            return;
        }
        System.out.print(n+" ");
        numberProgram(++n);
    }
    static void iterativeFibonacci(int n){
        if(n==0){
            System.out.println(0);
            return;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(prev+" ");
            int next =  prev + curr;
            prev = curr;
            curr = next;
        }
    }
    static int recursiveFibonacci(int n){
        if(n == 0) return 0;
        if(n <= 1){
            return n;
        }
        return recursiveFibonacci(n-1)+recursiveFibonacci(n-2);
    }
    static int binarySearch(int[] array,int target){
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    static int recursiveBinarySearch(int[] array,int target,int low,int high){
        if(low>high){
            return -1;
        }
        int mid = low + (high-low)/2;
        if(array[mid] == target){
            return mid;
        }
        else if(array[mid] < target){
            return recursiveBinarySearch(array,target,mid +1,high);
        }
        else{
            return recursiveBinarySearch(array,target,low,mid-1);
        }
    }
}

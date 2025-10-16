package basics.BitManipulation;

public class ToggleIthBit {
    public static void main(String[] args) {
        System.out.println(toggleIthBit(13,1));
    }
    private static int toggleIthBit(int n,int i){
        int mask = 1<<i;
        return n ^  mask;
    }
}

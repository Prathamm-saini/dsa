package basics.BitManipulation;

public class ClearIthBit {
    public static void main(String[] args) {
        System.out.println(clearIthBit(13,3));
    }
    /*
    logic is reach the i th position set it 0 else all 1 then do AND with original no
    AND -> if the ith bit is already 0 then & makes -> 0 if its 1 then also it makes -> 0

    create a bit mask -> i.e 1 at the ith bit position then just do ~ if it
    makes ith bit 0 else as 1 then do &
     */
    private static int clearIthBit(int n,int i){
        int mask = 1<<i;
        return n & ~mask;
    }
}

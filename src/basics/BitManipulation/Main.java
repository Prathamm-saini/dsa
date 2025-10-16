package basics.BitManipulation;
/*
Binary Addition
0+0 = 0;
0+1 = 1;
1+0 = 1;
1+1 = 10;
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(convertToBinary(7));
        System.out.println(convertToDecimal(new StringBuilder("111")));
        System.out.println(OnesComplement(new StringBuilder("10101010")));
        System.out.println(twosComplement(new StringBuilder("10101010")));
        operators(new StringBuilder("100"),new StringBuilder("101"),'^');
        System.out.println(rightShift(13));
        System.out.println(leftShift(13));

    }
    private static StringBuilder convertToBinary(int n){
        StringBuilder result = new StringBuilder();
        while(n>0){
            int remainder = n % 2 ;
            result.append(remainder);
            n/=2;
        }
        result.reverse();
        return result;
    }
    private static int convertToDecimal(StringBuilder n){
        int result = 0;
        int power = 0;
        for (int i = n.length()-1; i>=0 ; i--) {
            char bit = n.charAt(i);
            if(bit=='1'){
                result += (int)Math.pow(2,power);
            }
            power++;
        }
        return result;
    }
    private static StringBuilder OnesComplement(StringBuilder n){
        for(int i =0 ;i<n.length();i++){
            if(n.charAt(i)=='1'){
                n.setCharAt(i,'0');
            }
            else{
                n.setCharAt(i,'1');
            }
        }
        return n;
    }
    private static StringBuilder twosComplement(StringBuilder n){
       StringBuilder ones = OnesComplement(n);
        StringBuilder result = new StringBuilder(ones);
        int carry = 1;
        for (int i = result.length()-1; i>=0 ; i--) {
            char bit = result.charAt(i);
            if(bit=='1' && carry == 1){
                result.setCharAt(i,'0');
            }
            else if (bit=='0' && carry == 1){
                result.setCharAt(i,'1');
                carry = 0;
            }
        }
        if(carry == 1){
            result.insert(0,'1');
        }
        return result;
    }
    private static void operators(StringBuilder operand1,StringBuilder operand2,char operation){
        if(operation == '&'){
            int operand_1 = convertToDecimal(operand1);
            int operand_2 = convertToDecimal(operand2);
            System.out.println(operand_1 & operand_2);
        }
        if(operation == '|'){
            int operand_1 = convertToDecimal(operand1);
            int operand_2 = convertToDecimal(operand2);
            System.out.println(operand_1 | operand_2);
        }
        if(operation == '^'){
            int operand_1 = convertToDecimal(operand1);
            int operand_2 = convertToDecimal(operand2);
            System.out.println(operand_1 ^ operand_2);
        }
        /*
        NOT operator in Bit Manipulation
        step 1 -> flip all digits (0->1, 1->0)
        step 2-> check if -ve , then do 2's complement
        if +ve -> stop
         */
        if(operation == '~'){
            int operand_1 = convertToDecimal(operand1);
            int operand_2 = convertToDecimal(operand2);
            System.out.println(~operand_1);
            System.out.println(~operand_2);
        }
    }
    /*
    Some Theory on Left shift and Right shift

    Right Shift
    for right shift if number >> 1/2/3/.. any value
    we move the no of digits from LSB(the least significant bit)
    such that for 13 -> 1101 -> 1101>>1 -> 0110 (1 moves ahead and lost)
    if 13 >> 2 > 1101 >> 2 -> 0011

    Formula for right shift is Number/2^k (k-> no of times it has been masked )

    Left Shift
    same for left shift just move from the left
    example -> 13 << 1 -> 1101 << 1 -> 11010 (here 0 is added for the bit which moved ahead)

    formula is number * 2^k
     */
    private static int rightShift(int number){
        return number >> 1;
    }
    private static int leftShift(int number){
        return number << 1;
    }
}

/// For negative numbers in bit manipulation , computers stores it by converting it into 2's complement
/// earlier it was stored via reserving the 31'st bit as 1 but was inefficient and have wrong results many times
/// for example x = -13 binary value = 1101 onesComplement = 0010
/// (11111......1)0010 (in 32 bit representation) (Ones Complement)
/// now do binary addition of 1 to convert it into 2's complement
/// if the first digit of the number is 1 -> negative number
/// here it's -> 11....1 (0011) -> that's how negative numbers are stored in computers.
/// Largest value which can be stored in a computer is 2^31-1 -> Integer.MAXIMUM()
/// Smallest value which can be stored in a computer is -2^31- > Integer.MINIMUM()
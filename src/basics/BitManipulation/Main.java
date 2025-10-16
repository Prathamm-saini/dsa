package basics.BitManipulation;

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
        if(operation == '~'){
            int operand_1 = convertToDecimal(operand1);
            int operand_2 = convertToDecimal(operand2);
            System.out.println(~operand_1);
            System.out.println(~operand_2);
        }
    }
    private static int rightShift(int number){
        return number >> 1;
    }
    private static int leftShift(int number){
        return number << 1;
    }
}

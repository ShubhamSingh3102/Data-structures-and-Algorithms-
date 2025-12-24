package Bit_Manipulation;
import java.util.*;
public class Convert_decimal_to_binary {
    String convert2Binary(int n){
        // TC --> O(log n)
        // SC --> O(log n)
        if(n == 0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while(n>0){
            if(n%2==1){
                res.append("1");
            }
            else{
                res.append("0");
            }
            n = n/2;
        }
        res.reverse();
        return res.toString();
    }
    // inbuilt function --> Integer.toBinaryString(n);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();

        Convert_decimal_to_binary obj = new Convert_decimal_to_binary();

        String ans = obj.convert2Binary(n);
        System.out.println("Binary: " + ans);
    }
}
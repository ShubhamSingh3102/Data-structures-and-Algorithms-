package Bit_Manipulation;
import java.util.*;
public class Convert_binary_to_decimal {
    int convert2Decimal(String x){
        // TC --> O(len)
        // SC --> O(1)
        int len = x.length();
        int num = 0;
        int p2 = 1;  // 2^0
        for(int i = len-1; i >= 0;i--){
            if (x.charAt(i) == '1') {
                num = num + p2;
            }
            p2 = p2*2;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary number:");
        String x = sc.next();

        Convert_binary_to_decimal obj = new Convert_binary_to_decimal();
        int ans = obj.convert2Decimal(x);
        System.out.println("Decimal: " + ans);
    }
}

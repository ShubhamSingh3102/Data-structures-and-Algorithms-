package Bit_Manipulation;
import java.util.*;
public class Divide_two_Integers {
    int divideTwoIntegers(int dividend,int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if(dividend == divisor){
            return 1;
        }
        boolean sign = true; // positive
        if(dividend >= 0 && divisor < 0){
            sign = false; // negative
        }
        if(dividend <= 0 && divisor >= 0){
            sign = false; // negative
        }

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;
        while (n >= d){
            int count = 0;
            while (n >= d << (count+1)){
                count++;
            }
            ans = ans + (1 << count);
            n = n - ((d*(1L << count)));
        }

        if (ans >= (1L << 31) && sign) return Integer.MAX_VALUE;
        if (ans >= (1L << 31) && !sign) return Integer.MIN_VALUE;

        return sign ? (int) ans : (int)(-1 * ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dividend");
        int dividend = sc.nextInt();
        System.out.println("Enter the divisor");
        int divisor = sc.nextInt();
        Divide_two_Integers obj = new Divide_two_Integers();
        System.out.println(obj.divideTwoIntegers(dividend,divisor));
    }
}

//package Bit_Manipulation;
//import java.util.*;
//public class Concatenation_of_consecutive_Binary_Numbers_LeetCode_1680 {
//    public static int concatenatedBinary(int n){
//        int M = (int) 1e9 + 7;
//        long result = 0;
//
//        for(int num = 1; num <= n; num++){
//            int digits =  (int)(Math.log(num) / Math.log(2)) + 1;
//
//            result = ((result << digits) % M + num) % M;
//        }
//        return (int) result;
//    }
//    public static void main(String[] args) {
//        int n = 3;
//        System.out.println(concatenatedBinary(n));
//    }
//}




















package Bit_Manipulation;
import java.util.*;
public class Concatenation_of_consecutive_Binary_Numbers_LeetCode_1680 {
    public static int concatenatedBinary(int n){
        int M = (int) 1e9 + 7;
        int digits = 0;
        long result = 0;

        for(int num = 1; num <= n; num++){
            if((num & (num -1)) == 0){
                digits++;
            }
            result = ((result << digits) % M + num) % M;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(concatenatedBinary(n));
    }
}


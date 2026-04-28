//package Bit_Manipulation;
//import java.util.*;
//public class Complement_of_base_10_Integer_LeetCode_1009 {
//    //// Approach 1....
//    public static int bitwiseComplement(int n){
//        // TC ---> O(log2n)
//        // SC ---> O(1)
//        int result = 0;
//        int counter = 0;
//        if(n == 0) {
//            return 1;
//        }
//        while(n > 0){
//            int rem = n % 2;
//            result += (int) (Math.pow(2,counter)* (rem^1));
//            n = n / 2;
//            counter++;
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        int n = 5;
//        System.out.println(bitwiseComplement(n));
//    }
//}














package Bit_Manipulation;
import java.util.*;
public class Complement_of_base_10_Integer_LeetCode_1009 {
    //// Approach 2....
    public static int bitwiseComplement(int n){
        // TC ---> O(log2n)
        // SC ---> O(1)
        // find mask
        int mask = 1;
        while(mask < n){
            mask = (mask << 1) | 1;   // first left shift and then or with 1....
        }
        return mask ^ n;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(bitwiseComplement(n));
    }
}











//package Bit_Manipulation;
//import java.util.*;
//public class Complement_of_base_10_Integer_LeetCode_1009 {
//    //// Approach 3....
//    public static int bitwiseComplement(int n){
//        // TC ---> O(log2n)
//        // SC ---> O(1)
//
//        if(n == 0) {
//            return 1;
//        }
//        // find number of bit required to represent the number n...
//        int bits = (int)(Math.floor(Math.log(n) / Math.log(2))) +1;
//        int mask = (int) (Math.pow(2,bits) - 1);
//        return mask ^ n;
//    }
//    public static void main(String[] args) {
//        int n = 5;
//        System.out.println(bitwiseComplement(n));
//    }
//}

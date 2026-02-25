//package Bit_Manipulation;
//import java.util.*;
//public class Binary_Gap {
//    public static int binaryGap(int n){
//        int prev = -1;   //// previous 1 position
//        int maxGap = 0;
//        int curr = 0;    //// current bit position
//
//        while(n > 0){
//            if((n&1) > 0){  //// set bit
//                maxGap = (prev != -1) ? Math.max(maxGap, curr - prev) : maxGap;
//                prev = curr;
//            }
//            curr ++;
//            n >>= 1;   // right shift
//        }
//        return maxGap;
//    }
//    public static void main(String[] args) {
//        int n = 22;
//        System.out.println(binaryGap(n));
//    }
//}





















package Bit_Manipulation;
import java.util.*;
public class Binary_Gap {
    public static int binaryGap(int n){
        int prev = -1;   //// previous 1 position
        int maxGap = 0;

        for(int curr = 0; curr < 32; curr++ ){
            if(((n >> curr) & 1) > 0){
                maxGap = (prev != -1) ? Math.max(maxGap, curr - prev) : maxGap;
                prev = curr;
            }
        }
        return maxGap;
    }
    public static void main(String[] args) {
        int n = 22;
        System.out.println(binaryGap(n));
    }
}

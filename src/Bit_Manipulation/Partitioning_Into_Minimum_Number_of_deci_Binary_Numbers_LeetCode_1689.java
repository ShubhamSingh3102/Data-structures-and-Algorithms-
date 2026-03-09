//package Bit_Manipulation;
//import java.util.*;
//public class Partitioning_Into_Minimum_Number_of_deci_Binary_Numbers_LeetCode_1689 {
//    public static int minPartitions(String n){
//
//        char[] arr = n.toCharArray();   //// Converts string into character array...
//        int count = 0;
//
//        while(true) {
//            boolean changed = false;  //// To check if any digit was reduced in this round...
//
//            for(int i = 0;i < arr.length; i++){
//                if(arr[i] != '0') {
//                    arr[i]--;
//                    changed = true;
//                }
//            }
//            if(!changed){
//                break;
//            }
//
//            count++;
//        }
//        return count;
//    }
//    public static void main(String[] args) {
//        String n = "32";
//        System.out.println(minPartitions(n));
//    }
//}















package Bit_Manipulation;
import java.util.*;
public class Partitioning_Into_Minimum_Number_of_deci_Binary_Numbers_LeetCode_1689 {
    public static int minPartitions(String n){

        //// By tricks...
        char maxCh = '0';

        for(char ch : n.toCharArray()) {
            maxCh = (char)Math.max(maxCh,ch);
        }
        return maxCh - '0'; // convert to integer...
    }
    public static void main(String[] args) {
        String n = "32";
        System.out.println(minPartitions(n));
    }
}


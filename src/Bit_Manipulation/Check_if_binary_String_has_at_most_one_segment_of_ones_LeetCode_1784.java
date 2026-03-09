//package Bit_Manipulation;
//import java.util.*;
//public class Check_if_binary_String_has_at_most_one_segment_of_ones_LeetCode_1784 {
//    public static boolean checkOnesSegment(String s){
//        //// Approach 1.....
//        int n = s.length();
//        int count = 0;
//
//        int i = 0;
//        while (i < n){
//            if(s.charAt(i) == '1'){
//                // now traverse as a segment of one...
//                count++;
//                while(i < n && s.charAt(i) == '1'){
//                    i++;
//                }
//            } else {  // s.charAt(i) == '0'
//                i++;
//            }
//
//            if(count > 1){
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        String s = "1001";
//        System.out.println(checkOnesSegment(s));
//    }
//}


















package Bit_Manipulation;
import java.util.*;
public class Check_if_binary_String_has_at_most_one_segment_of_ones_LeetCode_1784 {
    public static boolean checkOnesSegment(String s){
        //// Approach 2.....
       return !s.contains("01");
    }
    public static void main(String[] args) {
        String s = "1001";
        System.out.println(checkOnesSegment(s));
    }
}

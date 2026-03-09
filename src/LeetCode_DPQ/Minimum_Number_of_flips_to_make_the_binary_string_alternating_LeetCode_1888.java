//package LeetCode_DPQ;
//import java.util.*;
//public class Minimum_Number_of_flips_to_make_the_binary_string_alternating_LeetCode_1888 {
//    public static int minFlips(String s){
//
//        int n = s.length();
//        s = s + s;
//
//        StringBuilder s1 = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//
//        for(int i = 0; i < 2*n ; i++){
//            s1.append(i % 2 == 1 ? '0' : '1');
//            s2.append(i % 2 == 1 ? '1' : '0');
//        }
//
//        int i = 0;
//        int j = 0;
//        int result = Integer.MAX_VALUE;
//        int flip1 = 0,flip2 = 0;
//
//
//        // khandani sliding windows technique....
//
//        while(j < 2*n) {
//            if (s.charAt(j) != s1.charAt(j)) {
//                flip1++;
//            }
//            if (s.charAt(j) != s2.charAt(j)) {
//                flip2++;
//            }
//
//
//            // shrink the window
//            if (j - i + 1 > n) {
//                if (s.charAt(i) != s1.charAt(i)) {
//                    flip1--;
//                }
//                if (s.charAt(i) != s2.charAt(i)) {
//                    flip2--;
//                }
//                i++;
//            }
//
//            // window size n
//            if (j - i + 1 == n) {
//                result = Math.min(result, Math.min(flip1, flip2));
//            }
//            j++;
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        String s = "111000";
//        System.out.println(minFlips(s));
//    }
//}






















// Optimised solution
//package LeetCode_DPQ;
//import java.util.*;
//public class Minimum_Number_of_flips_to_make_the_binary_string_alternating_LeetCode_1888 {
//    public static int minFlips(String s){
//
//        int n = s.length();
//
//        StringBuilder s1 = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//
//        for(int i = 0; i < 2*n ; i++){
//            s1.append(i % 2 == 1 ? '0' : '1');
//            s2.append(i % 2 == 1 ? '1' : '0');
//        }
//
//        int i = 0;
//        int j = 0;
//        int result = Integer.MAX_VALUE;
//        int flip1 = 0,flip2 = 0;
//
//
//        // khandani sliding windows technique....
//
//        while(j < 2*n) {
//            if (s.charAt(j % n) != s1.charAt(j)) {
//                flip1++;
//            }
//            if (s.charAt(j % n) != s2.charAt(j)) {
//                flip2++;
//            }
//
//
//            // shrink the window
//            if (j - i + 1 > n) {
//                if (s.charAt(i % n) != s1.charAt(i)) {
//                    flip1--;
//                }
//                if (s.charAt(i % n) != s2.charAt(i)) {
//                    flip2--;
//                }
//                i++;
//            }
//
//            // window size n
//            if (j - i + 1 == n) {
//                result = Math.min(result, Math.min(flip1, flip2));
//            }
//            j++;
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        String s = "111000";
//        System.out.println(minFlips(s));
//    }
//}






















// SC --> O(1)....
package LeetCode_DPQ;
import java.util.*;
public class Minimum_Number_of_flips_to_make_the_binary_string_alternating_LeetCode_1888 {
    public static int minFlips(String s){

        int n = s.length();

        int i = 0;
        int j = 0;
        int result = Integer.MAX_VALUE;
        int flip1 = 0,flip2 = 0;


        // khandani sliding windows technique....

        while(j < 2*n) {

            char expectedCharS1 = (j % 2 == 1) ? '1' : '0';
            char expectedCharS2 = (j % 2 == 1) ? '0' : '1';

            if (s.charAt(j % n) != expectedCharS1) {
                flip1++;
            }
            if (s.charAt(j % n) != expectedCharS2) {
                flip2++;
            }


            // shrink the window
            if (j - i + 1 > n) {

                expectedCharS1 = (i % 2 == 1) ? '1' : '0';
                expectedCharS2 = (i % 2 == 1) ? '0' : '1';


                if (s.charAt(i % n) != expectedCharS1) {
                    flip1--;
                }
                if (s.charAt(i % n) != expectedCharS2) {
                    flip2--;
                }
                i++;
            }

            // window size n
            if (j - i + 1 == n) {
                result = Math.min(result, Math.min(flip1, flip2));
            }
            j++;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "111000";
        System.out.println(minFlips(s));
    }
}

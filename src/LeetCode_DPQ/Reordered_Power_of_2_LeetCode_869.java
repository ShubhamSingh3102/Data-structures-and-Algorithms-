//package LeetCode_DPQ;
//import java.util.*;
//
//public class Reordered_Power_of_2_LeetCode_869 {
//
//    // Approach 1...
//    private String getSortedStr(int n) { //// t’s not that numbers can’t be traversed —
//    they can — but strings make it linear and direct,
//    while numbers require extra math steps to get each digit......
//        char[] arr = String.valueOf(n).toCharArray(); //"460" --> ['4','6','0'] /// 10 digits ---> 0(d)
//        Arrays.sort(arr); // ['4', '6', '0'] → ['0', '4', '6'] // 0(d log d)
//        return new String(arr); // ['0', '4', '6'] → "046"
//    }
//
//    public boolean reorderedPowerOf2(int n) {
//        String s = getSortedStr(n);
//        // TC --> 29*(d log d)
//        // SC --> 0(d) --> where d is no of digits....
//        // check all powers of 2 from 2^0 to 2^29
//        for (int p = 0; p <= 29; p++) { // 29
//            if (s.equals(getSortedStr(1 << p))) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Reordered_Power_of_2_LeetCode_869 obj = new Reordered_Power_of_2_LeetCode_869();
//        System.out.println(obj.reorderedPowerOf2(46));  // Example: true (46 -> 64 is power of 2)
//        System.out.println(obj.reorderedPowerOf2(10));  // Example: false
//    }
//}




//package LeetCode_DPQ;
//import java.util.*;
//
//public class Reordered_Power_of_2_LeetCode_869 {
//
//    private static Set<String> powerSet = new HashSet<>();
//
//    // Approach 2....
//    // Precompute sorted strings for all powers of 2 from 2^0 to 2^29
//    private static void buildSet() {
//        for (int p = 0; p <= 29; p++) {
//            int val = 1 << p;
//            char[] arr = String.valueOf(val).toCharArray();
//            Arrays.sort(arr);
//            powerSet.add(new String(arr));
//        }
//    }
//
//    public boolean reorderedPowerOf2(int n) {
//        if (powerSet.isEmpty()) {
//            buildSet(); // only once
//        }
//        char[] arr = String.valueOf(n).toCharArray(); // 0(d)
//        Arrays.sort(arr); // 0(d log d)
//        return powerSet.contains(new String(arr));
//    }
//
//    public static void main(String[] args) {
//        Reordered_Power_of_2_LeetCode_869 obj = new Reordered_Power_of_2_LeetCode_869();
//        System.out.println(obj.reorderedPowerOf2(46)); // true
//        System.out.println(obj.reorderedPowerOf2(10)); // false
//    }
//}





//package LeetCode_DPQ;
//import java.util.*;
//
//public class Reordered_Power_of_2_LeetCode_869{
//
//    // Converts an integer into a digit count array
//    private int[] getDigitCount(int n) {
//        int[] count = new int[10]; // indices 0-9 for each digit
//        while (n > 0) {
//            count[n % 10]++; // increment the count of the last digit
//            n /= 10;         // remove the last digit
//        }
//        return count;
//    }
//
//    public boolean reorderedPowerOf2(int n) {
//        int[] inputCount = getDigitCount(n);
//
//        // check all powers of 2 up to 2^29
//        for (int p = 0; p <= 29; p++) {
//            if (Arrays.equals(inputCount, getDigitCount(1 << p))) { // This is bitwise left shift: it moves the binary 1 left by p positions...
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Reordered_Power_of_2_LeetCode_869 obj = new Reordered_Power_of_2_LeetCode_869();
//        System.out.println(obj.reorderedPowerOf2(46)); // true
//        System.out.println(obj.reorderedPowerOf2(10)); // false
//    }
//}














package LeetCode_DPQ;
import java.util.*;

public class Reordered_Power_of_2_LeetCode_869{

    // Converts an integer into a digit count array
    private int getDigitCount(int n) {
        int num = 0;
        while (n > 0) {
            num += Math.pow(10, n % 10);
            n /= 10;         // remove the last digit
        }
        return num;
    }

    public boolean reorderedPowerOf2(int n) {
        int inputCount = getDigitCount(n);

        // check all powers of 2 up to 2^29
        for (int p = 0; p <= 29; p++) {
            if ( inputCount == getDigitCount(1 << p)) { // This is bitwise left shift: it moves the binary 1 left by p positions...
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Reordered_Power_of_2_LeetCode_869 obj = new Reordered_Power_of_2_LeetCode_869();
        System.out.println(obj.reorderedPowerOf2(46)); // true
        System.out.println(obj.reorderedPowerOf2(10)); // false
    }
}

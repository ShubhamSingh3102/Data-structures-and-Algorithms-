package LeetCode_DPQ;
import java.util.*;
// You are given a string num representing a large integer. An integer is good if it meets the following conditions:
//
//It is a substring of num with length 3.
//It consists of only one unique digit.
//Return the maximum good integer as a string or an empty string "" if no such integer exists.
//
//Note:
//
//A substring is a contiguous sequence of characters within a string.
//There may be leading zeroes in num or a good integer.
//
//
//Example 1:
//
//Input: num = "6777133339"
//Output: "777"
//Explanation: There are two distinct good integers: "777" and "333".
//"777" is the largest, so we return "777".
//Example 2:
//
//Input: num = "2300019"
//Output: "000"
//Explanation: "000" is the only good integer.
//Example 3:
//
//Input: num = "42352338"
//Output: ""
//Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
//
//
//Constraints:
//
//3 <= num.length <= 1000
//num only consists of digits...

public class Largest_3_Same_Digit_Number_in_String_LeetCode_2264 {

    public String largestGoodInteger(String num) {
        int n = num.length();
        char maxChar = 0; // use 0 to represent "not found"

        for (int i = 2; i < n; i++) {
            // check for three consecutive same digits
            if (num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i-2)) {
                if (num.charAt(i) > maxChar) {
                    maxChar = num.charAt(i);
                }
            }
        }

        if (maxChar == 0) {
            return "";
        }

        // repeat maxChar 3 times
        return "" + maxChar + maxChar + maxChar;
    }

    public static void main(String[] args) {
        Largest_3_Same_Digit_Number_in_String_LeetCode_2264 obj =
                new Largest_3_Same_Digit_Number_in_String_LeetCode_2264();

        System.out.println(obj.largestGoodInteger("6777133339")); // "777"
        System.out.println(obj.largestGoodInteger("2300019"));    // "000"
        System.out.println(obj.largestGoodInteger("4233352338"));   // ""
    }
}

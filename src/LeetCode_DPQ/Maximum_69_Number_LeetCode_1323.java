package LeetCode_DPQ;
import java.util.*;

// You are given a positive integer num consisting only of digits 6 and 9.
//
//Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
//
//
//
//Example 1:
//
//Input: num = 9669
//Output: 9969
//Explanation:
//Changing the first digit results in 6669.
//Changing the second digit results in 9969.
//Changing the third digit results in 9699.
//Changing the fourth digit results in 9666.
//The maximum number is 9969.
//Example 2:
//
//Input: num = 9996
//Output: 9999
//Explanation: Changing the last digit 6 to 9 results in the maximum number.
//Example 3:
//
//Input: num = 9999
//Output: 9999
//Explanation: It is better not to apply any change.
//
//
//Constraints:
//
//1 <= num <= 104
//num consists of only 6 and 9 digits.
public class Maximum_69_Number_LeetCode_1323 {
    public int maximum69Number(int num) {
        int placeValue = 0;
        int placeValueSix = -1;

        int temp = num;
        while (temp > 0) {
            int remain = temp % 10;

            if (remain == 6) {
                placeValueSix = placeValue; // store rightmost 6 position
            }

            temp = temp / 10;
            placeValue++;
        }

        if (placeValueSix == -1) { // no 6 found
            return num;
        }

        return num + 3 * (int) Math.pow(10, placeValueSix); // change 6 to 9
    }

    public static void main(String[] args) {
        Maximum_69_Number_LeetCode_1323 obj = new Maximum_69_Number_LeetCode_1323();

        int num1 = 9669;
        int num2 = 9996;
        int num3 = 9999;

        System.out.println("Input: " + num1 + " → Output: " + obj.maximum69Number(num1));
        System.out.println("Input: " + num2 + " → Output: " + obj.maximum69Number(num2));
        System.out.println("Input: " + num3 + " → Output: " + obj.maximum69Number(num3));
    }
}

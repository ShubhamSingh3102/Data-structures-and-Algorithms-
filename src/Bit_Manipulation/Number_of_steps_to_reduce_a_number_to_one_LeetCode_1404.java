package Bit_Manipulation;
import java.util.*;
public class Number_of_steps_to_reduce_a_number_to_one_LeetCode_1404 {
    public static int numSteps(String s){
        int n = s.length();
        int carry = 0;
        int ans = 0;

        for(int i = n-1; i >= 1; i--){
            if((s.charAt(i)-'0' + carry) % 2 == 1){   // odd
                ans += 2;
                carry = 1;    // right Shift and adding one...
            } else {
                ans += 1;    // only right Shift
            }
        }
        return ans + carry;    // here carry because we are not traversing last i....
    }
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }
}

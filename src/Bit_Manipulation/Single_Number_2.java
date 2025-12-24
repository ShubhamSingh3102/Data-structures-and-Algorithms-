package Bit_Manipulation;
import java.util.*;
public class Single_Number_2 {
    public static void main(String[] args) {
        int[] nums = {4,4,4,2,5,5,5};
        int n = nums.length;
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < n ; i++){
            ones = (ones ^ nums[i]) & ~ twos;
            twos = (twos ^ nums[i]) & ~ ones;
        }
        System.out.println(ones);
    }
}

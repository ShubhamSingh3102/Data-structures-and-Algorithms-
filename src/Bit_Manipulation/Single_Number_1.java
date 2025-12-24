package Bit_Manipulation;
import java.util.*;
public class Single_Number_1 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int xor = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            xor = xor ^ nums[i];
        }
        System.out.println(xor);
    }
}

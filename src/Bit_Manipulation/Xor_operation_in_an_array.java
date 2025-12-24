package Bit_Manipulation;
import java.util.*;
public class Xor_operation_in_an_array {
    public static void main(String[] args) {
        int start = 0;
        int n = 5;
//        int[] nums = new int[n];
//        for(int i=0;i<n;i++){
//            nums[i] = start + 2 * i;
//        }
//        int xor = 0;
//        for(int j=0;j<n;j++){
//            xor = xor ^ nums[j];
//        }

        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= (start + 2 * i);
        }
        System.out.println(xor);
    }
}

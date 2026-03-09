package Bit_Manipulation;
import java.util.*;
public class Find_kth_bit_in_nth_Binary_String_LeetCode_1545 {
    public static char findKthBit(int n, int k){
        //// TC --> O(N) and SC --> O(N)
        // base case...
        if(n == 1){
            return '0';
        }

        int length = (1 << n) - 1;  // pow(2,n) - 1

        if(k < Math.ceil(length/2.0)){
            return findKthBit(n-1,k);
        } else if( k == Math.ceil(length/2.0)){
            return '1';
        } else {
            char ch = findKthBit(n-1, length-(k-1));   // handled reversed...
            return (ch == '0') ? '1' : '0';
        }
    }
    public static void main(String[] args) {
        int n = 4, k = 11;
        System.out.println(findKthBit(n,k));
    }
}

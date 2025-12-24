package Bit_Manipulation;
import java.util.*;
public class Minimum_Bit_Flips_to_Convert_Number {
    int countSetBits(int n) {
        int count = 0;
        while (n > 1) {
//            if(n%2==1){ // remainder case....
//                count++;
//            }
//            n = n/2;
            count += n & 1;
            n = n >> 1;
        }
        if (n == 1) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        int ans = start ^ goal;
        Minimum_Bit_Flips_to_Convert_Number obj = new Minimum_Bit_Flips_to_Convert_Number();
        int result = obj.countSetBits(ans);
        System.out.println("Minimum bit flips needed: " + result);
    }
}
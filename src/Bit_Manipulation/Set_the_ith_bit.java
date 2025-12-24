package Bit_Manipulation;
import java.util.*;
public class Set_the_ith_bit {
    public static void main(String[] args) {
        int n = 9;
        int i = 2;
        int ans = n | (1 << i);
        System.out.println("Original : " + n);
        System.out.println("After setting bit " + i +": " + ans);
    }
}

package Bit_Manipulation;
import java.util.*;
public class Clearing_the_ith_bit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        int b = ~(1<<i);
        int ans = n & b;
        System.out.println("Original : " + n);
        System.out.println("After clearing bit " + i +": " + ans);
    }
}

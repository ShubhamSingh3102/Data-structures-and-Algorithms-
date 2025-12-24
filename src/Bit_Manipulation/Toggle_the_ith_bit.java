package Bit_Manipulation;
import java.util.*;
public class Toggle_the_ith_bit {
    public static void main(String[] args) {
        int n = 13; // 1101
        int i = 1;
        int toggle = n ^ (1 << i);
        System.out.println(toggle); // 1111
    }
}

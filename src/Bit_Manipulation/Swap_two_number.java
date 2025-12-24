package Bit_Manipulation;
import java.util.*;
public class Swap_two_number {
    public static void main(String[] args) {
        // a ^ a = 0
        // b ^ b = 0
        int a = 5;
        int b = 6;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + " " + b);
    }
}

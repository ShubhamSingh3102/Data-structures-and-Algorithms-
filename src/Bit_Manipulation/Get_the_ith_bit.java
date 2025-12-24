package Bit_Manipulation;
import java.util.*;
public class Get_the_ith_bit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        int bit = (n >> i) & 1;
        System.out.println(bit);
    }
}

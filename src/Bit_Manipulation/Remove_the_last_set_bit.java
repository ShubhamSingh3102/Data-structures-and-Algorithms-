package Bit_Manipulation;
import java.util.*;
public class Remove_the_last_set_bit {
    public static void main(String[] args) {
        // rightmost
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int remove = n & (n-1);
        System.out.println(remove);
    }
}

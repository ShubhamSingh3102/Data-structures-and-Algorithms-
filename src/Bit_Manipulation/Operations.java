package Bit_Manipulation;
import java.util.*;
public class Operations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers");
        int n = sc.nextInt();
        int p = sc.nextInt();
        int and = n & p;
        int or = n | p;
        int xor = n ^ p;
        int rightShift = n >> 1;
        int leftShift = n << 1;
        int m = 5;
        int not = ~(m);
        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
        System.out.println(rightShift);
        System.out.println(leftShift);
        System.out.println(not);
    }
}

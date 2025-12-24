package Bit_Manipulation;
import java.util.*;
public class Count_the_no_of_set_bits {
    // inBuilt count set bits function...
    // int setBits = Integer.bitCount(n);
    int countSetBits(int n){
        int count = 0;
        while(n>1){
//            if(n%2==1){ // remainder case....
//                count++;
//            }
//            n = n/2;
            count += n & 1;
            n = n >> 1;
        }
        if(n == 1){
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        Count_the_no_of_set_bits obj = new Count_the_no_of_set_bits();
        int ans = obj.countSetBits(n);

        System.out.println("Set bits = " + ans);
    }
}

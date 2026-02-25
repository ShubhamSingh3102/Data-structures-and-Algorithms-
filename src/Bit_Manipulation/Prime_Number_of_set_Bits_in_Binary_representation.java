package Bit_Manipulation;
import java.util.*;
public class Prime_Number_of_set_Bits_in_Binary_representation {
    public static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static int countPrimeSetBits(int left,int right){
        int result = 0;
        for(int i = left; i <= right ; i++){
            int count = Integer.bitCount(i); // count set bits

            if(isPrime(count)){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int left = 10;
        int right = 15;
        System.out.println(countPrimeSetBits(left,right));
    }
}

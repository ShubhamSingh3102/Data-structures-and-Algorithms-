package Bit_Manipulation;
import java.util.*;
public class Reverse_Bits {
    public static int reverseBits(int n){
        if(n == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0;i < 32; i++){
            result <<= 1;  // jagah banao....

            result = (result | (n & 1));  // n&1 se most significant bit mil jayega and or(|) se store kr do result me..
            // result me append kr do...

            n >>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }
}

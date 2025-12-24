package Bit_Manipulation;
import java.util.*;
public class Check_if_the_ith_bit_is_set_or_not {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;

//        Left shift operator
//        if(( n & (1 << i)) != 0){
//            System.out.println("Set");
//        }
//        else{
//            System.out.println("Not a set");
//        }


        // right Shift operator
        if((( n >> i) & 1) != 0){
            System.out.println("Set");
        }
        else{
            System.out.println("Not a set");
        }
    }
}

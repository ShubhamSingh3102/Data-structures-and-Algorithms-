package Bit_Manipulation;
import java.util.*;
public class Sort_Integers_by_the_numbers_of_1_bits {
    public static int[] sortByBits(int[] arr){

        Integer[] temp = new Integer[arr.length];

        for(int i=0; i<arr.length;i++){
            temp[i] = arr[i];
        }

        // Sort using custom lambda comparator....
        Arrays.sort(temp, (a,b) -> {
            int count_A = Integer.bitCount(a);
            int count_B = Integer.bitCount(b);

            if(count_A == count_B){
                return a - b;  // a comes first
            }
            return count_A - count_B;
        });
        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }
}

package Recursion_Problems;
import java.util.*;
public class Reverse_an_array {
    static void reverse(int[] arr,int l,int r){
        if(l >= r){
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        // now call recursion
        reverse(arr,l+1,r-1);
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,4,2};
        reverse(n,0,n.length -1);
        System.out.println(Arrays.toString(n));
    }
}

package Recursion_Problems;
import java.util.*;
public class Print_subsequences {
    static void printSubSequences(int idx,int[] arr,List<Integer> ds){
        int n = arr.length;
        if (idx >= n) {
            System.out.println(ds);
            return;
        }
        // TAKE the element → add, recurse
        ds.add(arr[idx]);
        printSubSequences(idx + 1, arr, ds);

        // NOT TAKE → remove, recurse
        ds.remove(ds.size() - 1);
        printSubSequences(idx + 1, arr, ds);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubSequences(0, arr, new ArrayList<>());
    }
}

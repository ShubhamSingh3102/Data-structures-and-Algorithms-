package Recursion_Problems;
import java.util.*;
public class Print_subsequences_whose_sum_is_K {
    static void printSubsequences(int idx,int[] arr,List<Integer> ds,int sum,int target){
        if(idx == arr.length){
            if(sum == target){
                System.out.println(ds);
            }
            return;
        }
        ds.add(arr[idx]);
        sum += arr[idx];
        printSubsequences(idx+1,arr,ds,sum,target);

        sum -= arr[idx];
        ds.remove(ds.size() -1);
        printSubsequences(idx+1,arr,ds,sum,target);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,1,2};
        printSubsequences(0,arr,new ArrayList<>(),0,2);
    }
}

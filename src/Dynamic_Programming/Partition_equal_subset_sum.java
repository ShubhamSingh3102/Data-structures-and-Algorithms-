package Dynamic_Programming;
import java.util.*;
public class Partition_equal_subset_sum {
    public static boolean isSubsetSum(int k,int[] arr){
        int n = arr.length;
        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];

        prev[0] = curr[0] = true;

        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        for(int index = 1;index <= n-1; index++){
            for(int target = 1; target <= k;target++){
                boolean notTaken = prev[target];
                boolean taken = false;
                if(target >= arr[index]) {
                    taken = prev[target - arr[index]];
                }
                curr[target] = taken || notTaken;
            }
            prev = curr.clone();
        }
        return prev[k];
    }
    public static boolean canPartition(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        if(sum % 2 != 0){ //// Odd cannot be divided into two equal parts...
            return false;
        }
        return isSubsetSum(sum/2,arr);
    }
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));
    }
}

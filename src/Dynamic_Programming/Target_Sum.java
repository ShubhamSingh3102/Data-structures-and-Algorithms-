package Dynamic_Programming;
import java.util.*;
public class Target_Sum {
//// Same question like count_partition_with_given_difference......
    public static int totalSubsets(int k,int[] arr){
        int n = arr.length;

        int[] prev = new int[k+1];
        int[] curr = new int[k+1];

        if(arr[0] == 0){
            prev[0] = 2;
        }
        else prev[0] = 1;

        if(arr[0] != 0 && arr[0] <= k){
            prev[arr[0]] = 1;
        }


        for(int index = 1;index <= n-1; index++){
            Arrays.fill(curr,0);
            if(arr[index] == 0)
                curr[0] = prev[0] * 2;
            else
                curr[0] = prev[0];
            for(int target = 1;target <= k; target++){
                int notTake = prev[target];
                int take = 0;
                if(target >= arr[index]){
                    take = prev[target-arr[index]];
                }
                curr[target] = take + notTake;
            }
            prev = curr.clone();
        }
        return prev[k];
    }
    public static int countPartitions(int n,int d,int[] arr){
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += arr[i];
        }
        if(totalSum - d < 0 || (totalSum -d) % 2 != 0){
            return 0;
        }
        int target = (totalSum - d)/2;
        return totalSubsets(target,arr);
    }
    public static int targetSum(int[] nums,int target){
        int n = nums.length;
        return countPartitions(n,target,nums);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(targetSum(nums,target));
    }
}

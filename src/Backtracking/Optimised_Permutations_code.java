package Backtracking;
import java.util.*;
public class Optimised_Permutations_code {
    // TC --> O(n!)
    // SC --> O(1)
    public static void recurPermute(int[] nums,int idx,List<List<Integer>> ans){
        // base condition....
        if(idx == nums.length - 1){
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }

        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            recurPermute(nums,idx+1,ans);
            swap(i,idx,nums);
        }
    }
    public static void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(nums,0,ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> ans = new Optimised_Permutations_code().permute(nums);
        System.out.println("All permutations:");
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}

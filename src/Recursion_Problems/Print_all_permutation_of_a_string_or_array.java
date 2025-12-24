package Recursion_Problems;
import java.util.*;
public class Print_all_permutation_of_a_string_or_array {
    public static void recurPermute(int[] nums,List<Integer> ds,List<List<Integer>> ans,boolean []freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]) { // Only choose numbers that are not used yet in the current permutation...
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums,ds,ans,freq);
                ds.remove(ds.size() - 1); // LIFO – stack style....
                freq[i] = false; // backtracking....
            }
        }
    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean []freq = new boolean[nums.length]; // by default--> false...
        recurPermute(nums,ds,ans,freq);
        return ans;
    }
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {'a','a','b','a','c'};

        List<List<Integer>> ans = new Print_all_permutation_of_a_string_or_array().permute(nums);
        System.out.println("All permutations:");
        for (List<Integer> list : ans) {
//            System.out.println(list);
            for(int val:list){
                System.out.print((char)val);
            }
            System.out.println();
        }
    }
}

package Backtracking;
import java.util.*;
public class Combination_Sum {
    private void findCombinations(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            // pick
            findCombinations(ind,arr,target - arr[ind],ans,ds);
            ds.remove(ds.size() - 1);
        }
        // not pick
        findCombinations(ind+1,arr,target,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        Combination_Sum obj = new Combination_Sum();
        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 7));
    }
}

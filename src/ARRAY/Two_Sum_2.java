package ARRAY;
import java.util.*;
public class Two_Sum_2 {
    // TC --> O(n)
    public static int[] twoSum(int[] number,int target){
        int n = number.length;
        int i = 0;
        int j = n - 1;
        while(i < j){
            int sum = number[i] + number[j];

            if(sum == target){
                return new int[]{i,j};
            } else if(sum < target){
                i++;
            } else { // sum > target because increasing order...
                j--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

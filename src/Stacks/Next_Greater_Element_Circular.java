package Stacks;
import java.util.*;
public class Next_Greater_Element_Circular {
    public static int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // preloading...
        // for giving chances to all element in circular array
        for(int i = n- 2; i >= 0; i--){
            st.push(nums[i]);
        }

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};

        int[] res = nextGreaterElements(nums);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}

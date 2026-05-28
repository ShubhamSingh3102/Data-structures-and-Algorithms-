package Stacks;
import java.util.*;
public class Daily_Temperatures {
    public static int[] dailyTemperatures(int[] temperatures){
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(n-1);
        ans[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = 0;
            } else {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}

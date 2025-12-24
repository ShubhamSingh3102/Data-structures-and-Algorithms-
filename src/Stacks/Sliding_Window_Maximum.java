package Stacks;
import java.util.Stack;
public class Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        // Time complexity: O(k*(n-k+1)) --> O(k*n)
        int n = arr.length;
//        n-(k-1) = n-k+1
       int[] ans = new int[n-k+1];
//        int z = 0;
//        for(int i=0;i<n-k+1;i++){
//            int max = Integer.MIN_VALUE;
//            for(int j=i;j<i+k;j++){
//                max = Math.max(max, arr[j]);
//            }
//            ans[z++] = max;
//        }
//        return ans;

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n-1] = n;
        st.push(arr[n-1]);
        int z = 0;
        for(int i=n-2;i>=0;i--){
            while( !st.isEmpty()&& arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = n;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        int j = 0;
        for(int i=0;i<n-k+1;i++){
            if(j>=i+k){ // jab j pura window se hi bahar nikal gya ho....
                j = i;
            }
            int max = Integer.MIN_VALUE;
            while(j<i+k){
                max = arr[j];
                j = nge[j];
            }
            ans[z++] = max;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = maxSlidingWindow(arr, k);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}

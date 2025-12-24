package Stacks;
import java.util.Stack;
public class Stock_Span_Problem {
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        st.push(0);
        res[0] = 1;
        for(int i=1;i<n;i++){
            while(!st.empty() && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                res[i] = i+1;
            }
            else{
                res[i] = i-st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}

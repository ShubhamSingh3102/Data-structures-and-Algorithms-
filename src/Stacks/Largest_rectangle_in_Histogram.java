package Stacks;
import java.util.Stack;
public class Largest_rectangle_in_Histogram {
    public static void main(String[] args) {
        int[] arr= {2,1,5,6,2,3};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        // calculating nse[]
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];
        int n = arr.length;

        // For the last element (n-1), next smaller doesn't exist, so set nse[n-1] = n
        nse[n-1] = n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.empty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        // emptying the stack
        while(!st.isEmpty()){
            st.pop();
        }
        // calculating pse[]
        int[] pse = new int[arr.length];
        st.push(0);
        pse[0] = -1;
        for(int i=1;i<=n-1;i++){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.empty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        // now calculating maximum area of rectangle...
        int max = -1;
        for(int i=0;i<n;i++){
            int area = arr[i]*(nse[i]-pse[i]-1);
            if(area>max){
                max = area;
            }
        }
        System.out.println(max);
    }
}



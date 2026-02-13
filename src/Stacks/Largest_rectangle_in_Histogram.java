//package Stacks;
//import java.util.Stack;
//public class Largest_rectangle_in_Histogram {
//    public static void main(String[] args) {
//        int[] arr= {2,1,5,6,2,3};
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//
//        // calculating nse[]
//        Stack<Integer> st = new Stack<>();
//        int[] nse = new int[arr.length];
//        int n = arr.length;
//
//        // For the last element (n-1), next smaller doesn't exist, so set nse[n-1] = n
//        nse[n-1] = n;
//        st.push(n-1);
//        for(int i=n-2;i>=0;i--){
//            while(!st.empty() && arr[st.peek()]>=arr[i]){
//                st.pop();
//            }
//            if(st.empty()){
//                nse[i] = n;
//            }
//            else{
//                nse[i] = st.peek();
//            }
//            st.push(i);
//        }
//        // emptying the stack
//        while(!st.isEmpty()){
//            st.pop();
//        }
//        // calculating pse[]
//        int[] pse = new int[arr.length];
//        st.push(0);
//        pse[0] = -1;
//        for(int i=1;i<=n-1;i++){
//            while(!st.empty() && arr[st.peek()]>=arr[i]){
//                st.pop();
//            }
//            if(st.empty()){
//                pse[i] = -1;
//            }
//            else{
//                pse[i] = st.peek();
//            }
//            st.push(i);
//        }
//        // now calculating maximum area of rectangle...
//        int max = -1;
//        for(int i=0;i<n;i++){
//            int area = arr[i]*(nse[i]-pse[i]-1);
//            if(area>max){
//                max = area;
//            }
//        }
//        System.out.println(max);
//    }
//}
//
//































package Stacks;
import java.util.Stack;
public class Largest_rectangle_in_Histogram {
    public static int LargestRectangle(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;;
        int maxArea = 0;
        for(int i=0;i<=n-1;i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                int area = arr[element] * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = arr[element] * (nse-pse-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
//        Stack<Integer> st = new Stack<>();
//        int n = arr.length;
//        int maxArea = 0;
//
//        for (int i = 0; i <= n; i++) {
//            int curr = (i == n) ? 0 : arr[i];
//
//            while (!st.isEmpty() && arr[st.peek()] > curr) {
//                int height = arr[st.pop()];
//                int nse = i;
//                int pse = st.isEmpty() ? -1 : st.peek();
//                maxArea = Math.max(maxArea, height * (nse - pse - 1));
//            }
//            st.push(i);
//        }
//        return maxArea;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(LargestRectangle(arr));
    }
}



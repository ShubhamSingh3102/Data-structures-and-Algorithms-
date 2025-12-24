package Stacks;
import java.util.*;
public class remove_ConsecutiveSubsequence {
    public static int[] removeConsecutive(int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty() || st.peek()!=arr[i]){
                st.push(arr[i]);
            }
            else if(st.peek() == arr[i]){
                if(i== arr.length-1 || arr[i] != arr[i+1]){
                    st.pop();
                }
//                if(arr[i] == arr[i+1]){ // do nothing
//                    i++;
//                }
            }
        }
        int[] res = new int[st.size()];
        int n = st.size();
        for(int i=n-1; i>=0; i--) {
            int x = st.pop();
            res[i] = x;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,10,10,10,4,4,4,5,7,7,2};
        int[] res = removeConsecutive(arr);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}

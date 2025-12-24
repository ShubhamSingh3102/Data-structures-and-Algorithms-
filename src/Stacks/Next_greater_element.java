package Stacks;
import java.util.Stack;
public class Next_greater_element {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};
        int[] res = new int[arr.length];
        int n = arr.length;
//        for(int i=0;i<arr.length;i++){
//            res[i] = -1;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[i]<arr[j]){
//                    res[i] = arr[j];
//                    break;
//                }
//            }
//        }
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        for(int i=0;i<arr.length;i++){
//            System.out.print(res[i]+" ");
//        }

        // pop answer push algorithm....
        Stack<Integer> st = new Stack<>();
        res[n-1] = -1;
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            while( !st.isEmpty()&& st.peek() < arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = st.peek();
            }
            st.push(arr[i]);
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

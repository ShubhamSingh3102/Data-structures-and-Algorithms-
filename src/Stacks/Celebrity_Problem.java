package Stacks;
import java.util.Stack;
public class Celebrity_Problem {
    public static int isCelebrity(int[][] matrix, int n){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i); // saara ko ek baar push kr do 0 to n-1 tk...// 0 1 2 in stack
        }
        while(st.size()>1){
            int v1 = st.pop();
            int v2 = st.pop();
            if(matrix[v1][v2] == 0){ // v1 v2 ko nhi jaanta..
                // sayad v1 celebrity ho...pr v2 to celebrity nhi h paaka...
                st.push(v1);
            }
            else if(matrix[v2][v1] == 0){
                st.push(v2);
            }
        }
        if(st.isEmpty()){ // st.size() == 0;
            return -1;
        }
        int potentialCelebrity = st.pop();
        // rows
        for(int j=0;j<n;j++){
            if(matrix[potentialCelebrity][j] == 1){
                return -1;
            }
        }
        // column
        for(int i=0;i<n;i++){
            if(i == potentialCelebrity){
                continue;
            }
            if(matrix[i][potentialCelebrity] == 0){
                return -1;
            }
        }
        return potentialCelebrity;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = {{0,1,0}, {0, 0, 0}, {0, 1, 0}};
//        int[][] matrix = {{0,1},{1,0}};
        System.out.println(isCelebrity(matrix, n));
    }
}

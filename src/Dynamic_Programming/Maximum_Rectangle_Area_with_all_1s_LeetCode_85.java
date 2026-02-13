package Dynamic_Programming;
import java.util.*;
public class Maximum_Rectangle_Area_with_all_1s_LeetCode_85 {
    public static int largestRectangleArea(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : arr[i];

            while (!st.isEmpty() && arr[st.peek()] > curr) {
                int height = arr[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, height * (nse - pse - 1));
            }
            st.push(i);
        }
        return maxArea;
    }
    public static int maximalRectangle(int[][] matrix,int n,int m){
        int maxArea = 0;
        int[] height = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if (matrix[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(maximalRectangle(matrix, n, m));
    }
}

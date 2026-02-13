//package ARRAY;
//import java.util.*;
//public class Minimum_Time_Visiting_all_points {
//    public static int minTime(int[][] points,int index){
//        // Recursive way
//        int n = points.length;;
//        if(index == n-1){
//            return 0;
//        }
//        int x1 = points[index][0];
//        int y1 = points[index][1];
//        int x2 = points[index+1][0];
//        int y2 = points[index+1][1];
//
//        int time = Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
//
//        return time + minTime(points,index+1);
//    }
//    public static void main(String[] args) {
//        int[][] points = {
//                {1,1},
//                {3,4},
//                {-1,0}
//        };
//        System.out.println(minTime(points,0));
//    }
//}







//package ARRAY;
//import java.util.*;
//public class Minimum_Time_Visiting_all_points {
//    public static int minTime(int[][] points,int index,int[] dp){
//        // Memoization way
//        int n = points.length;;
//        if(index == n-1){
//            return 0;
//        }
//        if(dp[index] != -1){
//            return dp[index];
//        }
//        int x1 = points[index][0];
//        int y1 = points[index][1];
//        int x2 = points[index+1][0];
//        int y2 = points[index+1][1];
//
//        int time = Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
//
//        return dp[index] = time + minTime(points,index+1,dp);
//    }
//    public static void main(String[] args) {
//        int[][] points = {
//                {1,1},
//                {3,4},
//                {-1,0}
//        };
//        int n = points.length;
//        int m = points[0].length;
//        int[] dp = new int[n];
//        Arrays.fill(dp,-1);
//        System.out.println(minTime(points,0,dp));
//    }
//}





















package ARRAY;
import java.util.*;
public class Minimum_Time_Visiting_all_points {
    public static int minTime(int[][] points){
        // Tabulation way
        int n = points.length;
        int[] dp = new int[n];

        dp[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];

            int time = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            dp[i] = time + dp[i+1];
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[][] points = {
                {1,1},
                {3,4},
                {-1,0}
        };
        System.out.println(minTime(points));
    }
}




















//package ARRAY;
//import java.util.*;
//public class Minimum_Time_Visiting_all_points {
//    public static int minTime(int[][] points){
//        int n = points.length;
//        int ans = 0;
//        for(int i=0;i<n-1;i++){
//            int x1 = points[i][0];
//            int y1 = points[i][1];
//            int x2 = points[i+1][0];
//            int y2 = points[i+1][1];
//
//            ans = ans + Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        int[][] points = {
//                {1,1},
//                {3,4},
//                {-1,0}
//        };
//        System.out.println(minTime(points));
//    }
//}

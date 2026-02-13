//package Dynamic_Programming;
//import java.util.*;
//public class Ninja_Training {
//    //// recursive way
//    public static int f(int day, int last, int[][] points) {
//        if (day == 0) {
//            int maxi = 0;
//            for (int task = 0; task < 3; task++) {
//                if (task != last) {
//                    maxi = Math.max(maxi, points[0][task]);
//                }
//            }
//            return maxi;
//        }
//
//        int maxi = 0;
//        for (int task = 0; task < 3; task++) {
//            if (task != last) {
//                int point = points[day][task] + f(day - 1, task, points);
//                maxi = Math.max(maxi, point);
//            }
//        }
//        return maxi;
//    }
//
//    static int ninjaTraining(int n, int[][] points) {
//        return f(n - 1, 3, points);
//    }
//
//    public static void main(String[] args) {
//        int[][] points = {
//                {10, 40, 70},
//                {20, 50, 80},
//                {30, 60, 90}
//        };
//
//        int n = points.length;
//        System.out.println(ninjaTraining(n, points));
//    }
//}
//





















//package Dynamic_Programming;
//import java.util.*;
//public class Ninja_Training {
//// Memoization way
//    public static int f(int day,int last,int[][] points,int[][] dp){
//        if(day == 0){
//            int maxi = 0;
//            for(int task = 0;task<3;task++){
//                if(task != last){
//                    maxi = Math.max(maxi,points[0][task]);
//                }
//            }
//            return maxi;
//        }
//
//        int maxi = 0;
//        if (dp[day][last] != -1) { //// Overlapping subProblems
//            return dp[day][last];
//        }
//        for(int task = 0;task<3;task++){
//            if(task != last){
//                int point = points[day][task] + f(day-1,task,points,dp);
//                maxi = Math.max(maxi,point);
//            }
//        }
//        return dp[day][last] = maxi;
//    }
//    static int ninjaTraining(int n, int[][] points) {
//        // 2D array represents dp
//        int[][] dp = new int[n][4];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        return f(n - 1, 3, points,dp);
//    }
//    public static void main(String[] args) {
//        int[][] points = {
//                {10, 40, 70},
//                {20, 50, 80},
//                {30, 60, 90}
//        };
//
//        int n = points.length;
//        System.out.println(ninjaTraining(n, points));
//    }
//}


























//package Dynamic_Programming;
//import java.util.*;
//public class Ninja_Training {
//    static int ninjaTraining(int n, int[][] points) {
//        //// Tabulation way....Time: O(N × 4 × 3)
//        /// Space: O(N × 4)
//        int[][] dp = new int[n][4];
//
//        // Base case (day = 0)
//        dp[0][0] = Math.max(points[0][1], points[0][2]);
//        dp[0][1] = Math.max(points[0][0], points[0][2]);
//        dp[0][2] = Math.max(points[0][0], points[0][1]);
//        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
//
//        for (int day = 1; day < n; day++) {
//            for (int last = 0; last < 4; last++) {
//                dp[day][last] = 0;
//                for (int task = 0; task < 3; task++) {
//                    if (task != last) {
//                        int point = points[day][task] + dp[day - 1][task];
//                        dp[day][last] = Math.max(dp[day][last], point);
//                    }
//                }
//            }
//        }
//
//        return dp[n - 1][3];
//    }
//
//    public static void main(String[] args) {
//        int[][] points = {
//                {10, 40, 70},
//                {20, 50, 80},
//                {30, 60, 90}
//        };
//        System.out.println(ninjaTraining(points.length, points));
//    }
//}

















package Dynamic_Programming;
import java.util.*;
public class Ninja_Training {
    static int ninjaTraining(int n, int[][] points) {
        //// Space Optimization....
        int[] prev = new int[4];

        // Base case (day = 0)
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];

            for (int last = 0; last < 4; last++) {
                temp[last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            prev = temp;   // move to next day
        }
        return prev[3];
    }
    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        System.out.println(ninjaTraining(points.length, points));
    }
}

//package Codeforce_Practice_Question;
//import java.util.*;
//public class Hit_the_Lottery {
//    public static class Main{
//        public static int minimumNumberOfBills(int[] nums,int index,int n){
//            if(n == 0){
//                return 0;
//            }
//            if(index == 0){
//                if(n % nums[index] == 0){
//                    return n/nums[index];
//                }
//                else{
//                    return (int)1e9;
//                }
//            }
//            int notTake = minimumNumberOfBills(nums,index-1,n);
//            int take = (int)1e9;
//            if(nums[index] <= n){
//                take = 1 + minimumNumberOfBills(nums,index,n-nums[index]);
//            }
//            return Math.min(notTake,take);
//        }
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Enter the numbers of dollars: ");
//            int n = sc.nextInt();
//            int[] nums = {1,5,10,20,100};
//            int p = nums.length;
//            System.out.println(minimumNumberOfBills(nums,p-1,n));
//        }
//    }
//}


























//package Codeforce_Practice_Question;
//import java.util.*;
//public class Hit_the_Lottery {
//    public static class Main{
//        public static int solve(int[] nums, int index, int n, int[][] dp) {
//            if (n == 0) return 0;
//
//            if (index == 0) {
//                if (n % nums[0] == 0) return n / nums[0];
//                return (int)1e9;
//            }
//
//            if (dp[index][n] != -1) return dp[index][n];
//
//            int notTake = solve(nums, index - 1, n, dp);
//            int take = (int)1e9;
//
//            if (nums[index] <= n) {
//                take = 1 + solve(nums, index, n - nums[index], dp);
//            }
//
//            return dp[index][n] = Math.min(notTake, take);
//        }
//
//
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Enter the numbers of dollars: ");
//            int n = sc.nextInt();
//            int[] nums = {1,5,10,20,100};
//            int p = nums.length;
//            int[][] dp = new int[p][n + 1];
//            for (int[] row : dp) {
//                Arrays.fill(row, -1);
//            }
//            System.out.println(solve(nums,p-1,n,dp));
//        }
//    }
//}































package Codeforce_Practice_Question;
import java.util.*;
public class Hit_the_Lottery {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the numbers of dollars: ");
            int n = sc.nextInt();
            int[] nums = {100,20,10,5,1};
            int p = nums.length;
            int count = 0;
            for(int i = 0;i<p;i++){
                count = count + n /nums[i];
                n = n % nums[i];
            }
            System.out.println(count);
        }
    }
}
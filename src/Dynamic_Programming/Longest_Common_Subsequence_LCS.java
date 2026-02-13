//package Dynamic_Programming;
//import java.util.*;
//public class Longest_Common_Subsequence_LCS {
//    //// Recursive way.....
//    public static int LongestCommonSubsequence(String str1,String str2,int ind1,int ind2){
//        if(ind1 < 0 || ind2 < 0){
//            return 0;
//        }
//        if(str1.charAt(ind1) == str2.charAt(ind2)){
//            return 1 + LongestCommonSubsequence(str1,str2,ind1-1,ind2-1);
//        }else{
//            return Math.max(LongestCommonSubsequence(str1,str2,ind1-1,ind2),LongestCommonSubsequence(str1,str2,ind1,ind2-1));
//        }
//    }
//    public static void main(String[] args) {
//        String str1 = "abcde";
//        String str2 = "ace";
//        int n = str1.length();
//        int m = str2.length();
//        System.out.println(LongestCommonSubsequence(str1,str2,n-1,m-1));
//    }
//}

















//package Dynamic_Programming;
//import java.util.*;
//public class Longest_Common_Subsequence_LCS {
//    //// Memoization way.....
//    public static int LongestCommonSubsequence(String str1,String str2,int ind1,int ind2,int[][] dp){
//        if(ind1 < 0 || ind2 < 0){
//            return 0;
//        }
//        if(dp[ind1][ind2] != -1){
//            return dp[ind1][ind2];
//        }
//        if(str1.charAt(ind1) == str2.charAt(ind2)){
//            return dp[ind1][ind2] = 1 + LongestCommonSubsequence(str1,str2,ind1-1,ind2-1,dp);
//        }else{
//            return dp[ind1][ind2] =  Math.max(LongestCommonSubsequence(str1,str2,ind1-1,ind2,dp),LongestCommonSubsequence(str1,str2,ind1,ind2-1,dp));
//        }
//    }
//    public static void main(String[] args) {
//        String str1 = "abcde";
//        String str2 = "ace";
//        int n = str1.length();
//        int m = str2.length();
//        int[][] dp = new int[n][m];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        System.out.println(LongestCommonSubsequence(str1,str2,n-1,m-1,dp));
//    }
//}





















//package Dynamic_Programming;
//import java.util.*;
//public class Longest_Common_Subsequence_LCS {
//    //// Tabulation way.....
//    public static int LongestCommonSubsequence(String str1,String str2){
//        int n = str1.length();
//        int m = str2.length();
//
//        int[][] dp = new int[n+1][m+1];
//
//        //// base case...
//        for (int i = 0; i <= n; i++){
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j <= m; j++){
//            dp[0][j] = 0;
//        }
//
//        for(int ind1 = 1; ind1 <= n;ind1++){
//            for(int ind2 = 1;ind2 <= m;ind2++){
//                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
//                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
//                }else{
//                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
//                }
//            }
//        }
//        return dp[n][m];
//    }
//    public static void main(String[] args) {
//        String str1 = "abcde";
//        String str2 = "ace";
//        System.out.println(LongestCommonSubsequence(str1,str2));
//    }
//}















package Dynamic_Programming;
import java.util.*;
public class Longest_Common_Subsequence_LCS {
    //// Optimisation way.....
    public static int LongestCommonSubsequence(String str1,String str2){
        int n = str1.length();
        int m = str2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        //// base case...
        for (int i = 0; i <= m; i++){
            prev[i] = 0;
        }
        for(int ind1 = 1; ind1 <= n;ind1++){
            for(int ind2 = 1;ind2 <= m;ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                    curr[ind2] = 1 + prev[ind2-1];
                }else{
                    curr[ind2] = Math.max(prev[ind2],curr[ind2-1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(LongestCommonSubsequence(str1,str2));
    }
}
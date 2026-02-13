package Dynamic_Programming;
import java.util.*;
public class Print_Longest_Common_Subsequences {
    public static void PrintLongestCommonSubsequences(String s,String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        //// base case...
        for (int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }
        // DP table filling
        for(int i = 1; i <= n; i++){
            for(int j = 1 ; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int len = dp[n][m];
        char[] ans = new char[len];

        int index = len - 1;
        int i = n, j = m;

        // Backtracking to build LCS
        while(i>0 && j>0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                ans[index] = s.charAt(i-1);
                index--;
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println("LCS = " + new String(ans)) ;
    }
    public static void main(String[] args) {
        String s = "abcde";
        String t = "bdgek";
        PrintLongestCommonSubsequences(s,t);
    }
}

package Dynamic_Programming;
import java.util.*;
public class Longest_Common_Substring {
    public static int LongestCommonSubstring(String s,String t){
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

        int ans = 0;
        // DP table filling
        for(int i = 1; i <= n; i++){
            for(int j = 1 ; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abzd";

        System.out.println(LongestCommonSubstring(s1, s2));
    }
}

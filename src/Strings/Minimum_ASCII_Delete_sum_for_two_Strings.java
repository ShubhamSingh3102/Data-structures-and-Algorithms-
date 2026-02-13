//package Strings;
//import java.util.*;
//public class Minimum_ASCII_Delete_sum_for_two_Strings {
//    public static int minimumDeleteSum(String s1,String s2,int i,int j){
//        //// recursive way....
//        // s1 finished → delete rest of s2
//        //// base case....
//        if(i == s1.length()){
//            int sum = 0;
//            for(int k = j;k<s2.length();k++){
//                sum += s2.charAt(k);
//                return sum;
//            }
//        }
//        //// base case.....
//        if(j == s2.length()){
//            int sum = 0;
//            for(int k = i;k<s1.length();k++){
//                sum += s1.charAt(k);
//                return sum;
//            }
//        }
//        char ch = s1.charAt(i);
//        char sh = s2.charAt(j);
//
//        // same character
//        if(sh == ch){
//            return minimumDeleteSum(s1,s2,i+1,j+1);
//        }
//
//        // different character
//        return Math.min(ch + minimumDeleteSum(s1,s2,i+1,j),sh + minimumDeleteSum(s1,s2,i,j+1));
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter string1: ");
//        String s1 = sc.next();
//        System.out.print("Enter string2: ");
//        String s2 = sc.next();
//        System.out.println(minimumDeleteSum(s1,s2,0,0));
//    }
//}

















//package Strings;
//import java.util.*;
//public class Minimum_ASCII_Delete_sum_for_two_Strings {
//    public static int minimumDeleteSum(String s1,String s2,int i,int j,int[][] dp){
//        //// Memoization way....
//        // s1 finished → delete rest of s2
//        //// base case....
//        if(i == s1.length()){
//            int sum = 0;
//            for(int k = j;k<s2.length();k++){
//                sum += s2.charAt(k);
//            }
//            return sum;
//        }
//        //// base case.....
//        if(j == s2.length()){
//            int sum = 0;
//            for(int k = i;k<s1.length();k++){
//                sum += s1.charAt(k);
//            }
//            return sum;
//        }
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//        char ch = s1.charAt(i);
//        char sh = s2.charAt(j);
//
//        // same character
//        if(sh == ch){
//            return dp[i][j] =  minimumDeleteSum(s1,s2,i+1,j+1,dp);
//        }
//
//        // different character
//        return dp[i][j] = Math.min(ch + minimumDeleteSum(s1,s2,i+1,j,dp),sh + minimumDeleteSum(s1,s2,i,j+1,dp));
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter string1: ");
//        String s1 = sc.next();
//        int n = s1.length();
//        System.out.print("Enter string2: ");
//        String s2 = sc.next();
//        int m = s2.length();
//        int[][] dp = new int[n][m];
//        for(int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        System.out.println(minimumDeleteSum(s1,s2,0,0,dp));
//    }
//}



















package Strings;
import java.util.*;
public class Minimum_ASCII_Delete_sum_for_two_Strings {
    public static int minimumDeleteSum(String s1,String s2){
        //// Tabulation way....
        // s1 finished → delete rest of s2
        //// base case....
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + s2.charAt(j);
        }

        // base case: s2 finished → delete rest of s1
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + s1.charAt(i);
        }


        for(int i = n-1;i >= 0; i--){
            for(int j = m-1;j >= 0; j--) {
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(s1.charAt(i) + dp[i+1][j],s2.charAt(j) + dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string1: ");
        String s1 = sc.next();
        int n = s1.length();
        System.out.print("Enter string2: ");
        String s2 = sc.next();
        int m = s2.length();
        int[][] dp = new int[n][m];
        System.out.println(minimumDeleteSum(s1,s2));
    }
}

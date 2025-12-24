//package Dynamic_Programming;
//import java.util.*;
//
//
////// Memoization way....//// TC ---> O(N) and SC ---> O(N)+O(N)
//public class Fibonacci_Number {
//    static int[] dp;
//    static int fibonacci(int n){
//        if(n == 0) {
//            return 0;
//        }
//        if(n == 1){
//            return 1;
//        }
//        if(dp[n] != -1){ // already computed
//            return dp[n];
//        }
//        return dp[n] = fibonacci(n-1) + fibonacci(n-2);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the value of n: ");
//        int n = sc.nextInt();
//        dp = new int[n+1];
//        Arrays.fill(dp,-1);
//
//        System.out.println(fibonacci(n));
//    }
//}




















//package Dynamic_Programming;
//import java.util.*;
////// Tabulation way....TC ---> O(N) and SC ---> O(N)
//public class Fibonacci_Number {
//    static int[] dp;
//    static int fibonacci(int n){
//
//        // Base cases
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for(int i=2;i<=n;i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the value of n: ");
//        int n = sc.nextInt();
//        dp = new int[n+1];
//        System.out.println(fibonacci(n));
//    }
//}
















package Dynamic_Programming;
import java.util.*;
//// Optimised way....TC ---> O(N) and SC ---> O(1)
public class Fibonacci_Number {
    static int fibonacci(int n){

        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int prev2 = 0;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
}

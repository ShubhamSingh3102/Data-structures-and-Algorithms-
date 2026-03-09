//package Dynamic_Programming;
//import java.util.*;
//public class Find_all_possible_Stable_Binary_Arrays_I {
//    //Approach-1 (Recursion + Memoization)
//    //T.C : O(one * zero * limit)
//    //S.C : O(one * zero)
//    static int M = 1_000_000_007;
//    static int[][][] t = new int[201][201][2];
//
//    public static int solve(int onesLeft,int zeroesLeft,int lastWasOne,int limit){
//        if(onesLeft == 0 && zeroesLeft == 0){
//            return 1;
//        }
//        if(t[onesLeft][zeroesLeft][lastWasOne] != -1){
//            return t[onesLeft][zeroesLeft][lastWasOne];
//        }
//
//        int result = 0;
//        if(lastWasOne == 1){
//            // explore 0s
//            for(int len = 1; len <= Math.min(zeroesLeft,limit); len++){
//                result += solve(onesLeft,zeroesLeft-len,0,limit) % M;
//            }
//        } else {
//            // explore 1s
//            for(int len = 1; len <= Math.min(onesLeft,limit); len++){
//                result += solve(onesLeft-len,zeroesLeft,1,limit) % M;
//            }
//        }
//        return t[onesLeft][zeroesLeft][lastWasOne] = result;
//    }
//    public static int numberOfStableArrays(int zero,int one,int limit){
//        for(int i = 0; i < t.length; i++){
//            for(int j = 0; j < t[i].length; j++){
//                for(int k = 0; k < t[i][j].length; k++){
//                    t[i][j][k] = -1;
//                }
//            }
//        }
//
//        int startWithOne = solve(one,zero,0,limit);
//        int startWithZero = solve(one,zero,1,limit);
//
//        return (startWithOne + startWithZero) % M;
//    }
//    public static void main(String[] args) {
//        int zero = 3;
//        int one = 3;
//        int limit = 2;
//        System.out.println(numberOfStableArrays(zero,one,limit));
//    }
//}

















package Dynamic_Programming;
import java.util.*;
public class Find_all_possible_Stable_Binary_Arrays_I {
    //Approach-2 (Bottom Up)
    //T.C : O(one * zero * limit)
    //S.C : O(one * zero)
    public static int numberOfStableArrays(int zero,int one,int limit){

        int M = 1_000_000_007;
        int[][][] t = new int[201][201][2];

        // base case....
        t[0][0][0] = 1;
        t[0][0][1] = 1;

        for(int onesLeft = 0; onesLeft <= one; onesLeft++){
            for(int zeroesLeft = 0; zeroesLeft <= zero; zeroesLeft++){
                if(onesLeft == 0 && zeroesLeft == 0){
                    continue;
                }


                // if(lastWasOne == true) { explore 0s }
                int result = 0;
               for(int len = 1; len <= Math.min(zeroesLeft,limit); len++){
                   result += t[onesLeft][zeroesLeft-len][0] % M;
               }
               t[onesLeft][zeroesLeft][1] = result;

                // else { explore 1s }
                result = 0;
                for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                    result = (result + t[onesLeft - len][zeroesLeft][1]) % M;
                }
                t[onesLeft][zeroesLeft][0] = result;
            }
        }

        int startWithOne = t[one][zero][0];
        int startWithZero = t[one][zero][1];

        return (startWithOne + startWithZero) % M;
    }
    public static void main(String[] args) {
        int zero = 3;
        int one = 3;
        int limit = 2;
        System.out.println(numberOfStableArrays(zero,one,limit));
    }
}

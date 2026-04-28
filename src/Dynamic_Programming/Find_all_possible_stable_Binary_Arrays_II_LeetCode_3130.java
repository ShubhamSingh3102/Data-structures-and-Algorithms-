package Dynamic_Programming;
import java.util.*;
public class Find_all_possible_stable_Binary_Arrays_II_LeetCode_3130 {
    //Approach-2 (Bottom Up)
    //T.C : O(one * zero * limit)
    //S.C : O(one * zero)
    public static int numberOfStableArrays(int zero,int one,int limit){

        int M = 1_000_000_007;
        int[][][] t = new int[zero+1][one+1][2];

        // base case....
        for(int i = 1; i<= Math.min(zero,limit); i++){
            t[i][0][0] = 1;
        }
        for(int j = 1; j<= Math.min(one,limit); j++){
            t[0][j][1] = 1;
        }

        // main function call
        for(int i = 0; i <= zero; i++){
            for(int j = 0; j <= one; j++){

                if(i == 0 || j == 0){
                    continue;
                }

                // end with 1
                 t[i][j][1] = (t[i][j-1][0] + t[i][j-1][1]) % M;

                if(j-1 >= limit){
                    t[i][j][1] = (t[i][j][1] - t[i][j-1-limit][0] + M) % M;
                }

                t[i][j][0] = (t[i-1][j][0] + t[i-1][j][1]) % M;

                if(i-1 >= limit){
                    t[i][j][0] = (t[i][j][0] - t[i-1-limit][j][1] + M) % M;
                }
            }
        }
        return (t[zero][one][0] + t[zero][one][1]) % M;
    }
    public static void main(String[] args) {
        int zero = 3;
        int one = 3;
        int limit = 2;
        System.out.println(numberOfStableArrays(zero,one,limit));
    }
}

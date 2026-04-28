package LeetCode_DPQ;
import java.util.*;
public class Furthest_Point_from_origin_LeetCode_2833 {
    public static int furthestDistanceFromOrigin(String moves){
        int right = 0;
        int left = 0;
        int dash = 0;

        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                left++;
            } else if(ch == 'R'){
                right++;
            }
            else {
                dash++;
            }
        }
        return Math.abs(left - right) + dash;
    }
    public static void main(String[] args) {
        String moves = "L_RL__R";
        System.out.println(furthestDistanceFromOrigin(moves));
    }
}

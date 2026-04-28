package LeetCode_DPQ;
import java.util.*;
public class Shortest_Distance_to_target_string_in_a_circular_array_LeetCode_2515 {
    public static int closestTarget(String[] words,String target, int startIndex){
        // TC --> O(n*L)
        // SC --> O(1)
        int result = Integer.MAX_VALUE;
        int n = words.length;;
        for(int i = 0; i < n; i++){
            if(words[i].equals(target)){
                int straightDistance = Math.abs(i-startIndex);
                int circularDistance = (n - straightDistance);
                result = Math.min(result,straightDistance);
                result = Math.min(result,circularDistance);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    public static void main(String[] args) {
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println(closestTarget(words,target,startIndex));
    }
}

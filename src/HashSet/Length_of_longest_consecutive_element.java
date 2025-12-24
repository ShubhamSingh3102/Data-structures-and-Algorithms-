package HashSet;
import java.util.*;
public class Length_of_longest_consecutive_element {
    static int longestConsecutive(int[] arr){
        HashSet<Integer> st = new HashSet<>();
        // TC--> 0(n)...
        // arr ke saare element ko set ke andar add kro...
        for(int num : arr){
            st.add(num);
        }
        int maxStreak = 0;
        // now traverse through set...
        for(int num : st) {
            // for starting point...
            if (!st.contains(num - 1)) { // num is starting point of a sequence....
                int currNum = num;
                int currStreak = 1; // length of current consecutive sequence...
                while (st.contains(currNum + 1)) {
                    currStreak++;
                    currNum++;
                }
                maxStreak = Math.max(maxStreak,currStreak);
            }
        }
        return maxStreak;
    }
    public static void main(String[] args) {
        int[] arr = {99,1,100,4,200,1,2,2,3};
//        int[] arr = {0,2,5,4,6,7,8,1,3};
        int result = longestConsecutive(arr);
        System.out.println(result);
    }
}

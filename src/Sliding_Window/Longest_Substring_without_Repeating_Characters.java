package Sliding_Window;
import java.util.*;
public class Longest_Substring_without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s){
        HashMap<Character,Integer> map = new HashMap<>();

        // TC --> O(n)
        // SC --> O(1)
        int low = 0;
        int high = 0;
        int result = Integer.MIN_VALUE;

        while(high < s.length()){
            // high ko information me add kro....
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0) + 1);

            int k = high - low + 1;  // window size...

            // galat hoga then window shrink krega...low badhaega...f.size() < k galat hai...
            //// f.size() > k --> kabhi nhi ho skta hai,,,

            while(map.size() < k){
                char leftChar = s.charAt(low);
                map.put(leftChar,map.get(leftChar) - 1);

                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                low++;
                // k is dependent here
                k = high - low + 1;
            }
            // equal h...
            int len = high - low + 1;
            result = Math.max(len,result);
            high++;
        }
        return (result == Integer.MIN_VALUE) ? 0 : result;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

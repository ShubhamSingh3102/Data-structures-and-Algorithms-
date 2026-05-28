package Sliding_Window;
import java.util.*;
public class Longest_Substring_with_k_distinct {
    public static int longestSubstring(String s,int k){
        HashMap<Character,Integer> map = new HashMap<>();

        // TC --> O(n)
        // SC --> O(k)
        // Variable Sliding Window...
        int low = 0;
        int high = 0;

        int result = Integer.MIN_VALUE;

        while(high < s.length()){
            // count frequency of character ---> high ko include kr lo aapna information me...
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch,0) + 1);

            // if map ka size == k ho jaaye then information ekdam sahi ho jayega...
            // ya information galat ho jaaye....map.size > k or map.size < k
            // map.size < k already kaam h then usko shrink krke aur kaam kyu krna hai....
            // map.size > k low ko badhana hai...window shrink krna hai....
            while(map.size() > k){
                // low ko badhao...window size decrease kro...
                char leftChar = s.charAt(low);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0){
                    // now remove it from the map;
                    map.remove(leftChar);
                }
                low++;
            }
            // now 2 cases....map.size == k or map.size < k
            if(map.size() == k){
                int length = high - low + 1;
                result = Math.max(length,result);
            }
            high++;
        }
        return (result == Integer.MIN_VALUE) ? -1 : result;
    }
    public static void main(String[] args) {
        String s ="aabacbebebe";
        int k = 3;
        System.out.println(longestSubstring(s,k));
    }
}



// first high ko include kro information me....
// jab tk galat hai tb tk low ko decrease kro...low ko badhao
// jo information sahi h usko include kr lo result me....

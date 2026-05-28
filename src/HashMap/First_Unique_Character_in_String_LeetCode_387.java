package HashMap;
import java.util.*;
public class First_Unique_Character_in_String_LeetCode_387 {
    public static int firstUniqChar(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(map.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}

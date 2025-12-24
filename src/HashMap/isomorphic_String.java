package HashMap;
import java.util.*;
public class isomorphic_String {
    static boolean isIsomorphic(String s,String t){
        HashMap<Character,Character> mp = new HashMap<>();
        HashSet<Character> st = new HashSet<>();
        if(s.length() != t.length()){
            return false;
        }
        // TC---> O(n^2)
        // TC---> containsValue---> 0(n^2)
        for(int i=0;i<s.length();i++){
            char sCh = s.charAt(i); // key
            char tCh = t.charAt(i); // value

            if(mp.containsKey(sCh)) { // if map contains s character
                if (mp.get(sCh) != tCh) { // Check if previously mapped character is different
                    return false;
                }
            }
            // If tCh is already mapped to some other sCh
            else {
//                if (mp.containsValue(tCh)) {// a-->x and d-->x which is wrong...checks if any key in the map already maps to tCh.
//                    return false;
//                }
                if (st.contains(tCh)) {// a-->x and d-->x which is wrong...checks if any key in the map already maps to tCh.
                    return false;
                }
                mp.put(sCh,tCh);
                st.add(tCh);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abcba";
        String t = "xywyx";
        System.out.println(isIsomorphic(s,t));
    }
}

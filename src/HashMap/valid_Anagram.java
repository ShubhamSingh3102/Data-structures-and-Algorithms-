package HashMap;
import java.util.*;
public class valid_Anagram {
//    static void isAnagram(String s, String t){
//        HashMap<Character,Integer> mp1 = new HashMap<>();
//        HashMap<Character,Integer> mp2 = new HashMap<>();
//
//        if(s.length() != t.length()){
//            System.out.println("Not Anagram");
//            return;
//        }
//
//        for(var el : s.toCharArray()){
//            if(!mp1.containsKey(el)){
//                mp1.put(el,1);
//            }
//            else{
//                mp1.put(el,mp1.get(el)+1);
//            }
//        }
//
//        for(var el : t.toCharArray()){
//            if(!mp2.containsKey(el)){
//                mp2.put(el,1);
//            }
//            else{
//                mp2.put(el,mp2.get(el)+1);
//            }
//        }
//        if(mp1.equals(mp2)){
//            System.out.println("Anagram");
//        }
//        else{
//            System.out.println("Not Anagram");
//        }
//    }
static void isAnagram1(String s, String t){
    HashMap<Character,Integer> mp = new HashMap<>();

    if(s.length() != t.length()){
        System.out.println("Not Anagram");
        return;
    }

    for(var el : s.toCharArray()){
        if(!mp.containsKey(el)){
            mp.put(el,1);
        }
        else{
            mp.put(el,mp.get(el)+1);
        }
    }

    for(var el : t.toCharArray()){
        if(!mp.containsKey(el)){
            System.out.println("Not Anagram");
            return;
        }
        else{
            mp.put(el,mp.get(el)-1);
        }
    }
    // All values should be zeroes for s and t to be anagram...
    for(int i : mp.values()){
        if(i!=0){
            System.out.println("Not Anagram");
            return;
        }
    }
    System.out.println("Anagram");
}
    public static void main(String[] args) {
        String s = "silent";
        String t = "listen";
        isAnagram1(s,t);
    }
}

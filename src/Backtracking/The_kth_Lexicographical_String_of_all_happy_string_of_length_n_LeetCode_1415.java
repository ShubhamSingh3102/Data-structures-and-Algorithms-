package Backtracking;
import java.util.*;
public class The_kth_Lexicographical_String_of_all_happy_string_of_length_n_LeetCode_1415 {
    //// Approach 1....
    public static String getHappyString(int n,int k){
        List<String> list = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        generate(curr,n,list);

        if(k > list.size()){
            return "";  // empty string....
        }
        return list.get(k-1);
    }
    public static void generate(StringBuilder curr,int n,List<String>list){
        if(curr.length() == n){
            list.add(curr.toString());
            return;
        }
        for(char ch = 'a'; ch <= 'c'; ch++){
            if(curr.length() > 0 && curr.charAt(curr.length() -1) == ch){
                continue;
            }

            // Do
            curr.append(ch);

            // Explore
            generate(curr,n,list);

            // Undo
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 9;
        System.out.println(getHappyString(n,k));
    }
}



















//package Backtracking;
//import java.util.*;
//public class The_kth_Lexicographical_String_of_all_happy_string_of_length_n_LeetCode_1415 {
//    //// Approach 2....
//    public static String getHappyString(int n,int k){
//        StringBuilder curr = new StringBuilder();
//        String[] result = {""};
//
//        int[] count = {0};
//        generate(curr,n,count,k,result);
//
//        return result[0];
//    }
//    public static void generate(StringBuilder curr,int n,int[] count,int k,String[] result){
//        if(curr.length() == n){
//            count[0]++;
//            if(count[0] == k){
//                result[0] = curr.toString();
//            }
//            return;
//        }
//        for(char ch = 'a'; ch <= 'c'; ch++){
//            if(curr.length() > 0 && curr.charAt(curr.length() -1) == ch){
//                continue;
//            }
//
//            // Do
//            curr.append(ch);
//
//            // Explore
//            generate(curr,n,count,k,result);
//
//            // if result found, exit early...
//            if(!result[0].isEmpty()){
//                return;
//            }
//
//            // Undo
//            curr.deleteCharAt(curr.length() - 1);
//        }
//    }
//    public static void main(String[] args) {
//        int n = 3;
//        int k = 9;
//        System.out.println(getHappyString(n,k));
//    }
//}

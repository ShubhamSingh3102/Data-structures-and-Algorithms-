package Backtracking;
import java.util.*;
public class print_Permutations {
//    public static void printP(String str,String t){
//        if(str.equals("")){
//            System.out.println(t);
//            return;
//        }
//        for(int i=0;i<str.length();i++){
//            char ch = str.charAt(i); // b
//            String left = str.substring(0,i); // a
//            String right = str.substring(i+1); // c
//            String rem = left + right;
//            printP(rem,t+ch);
//        }
//    }
//    public static void main(String[] args) {
//        String str = "abc";
//        printP(str,"");
//    }

























    public static void printP(String str,String t,List<String> l){
        if(str.equals("")){
            l.add(t);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i); // b
            String left = str.substring(0,i); // a
            String right = str.substring(i+1); // c
            String rem = left + right;
            printP(rem,t+ch,l);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        List<String> l = new ArrayList<>();
        printP(str,"",l);
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
}

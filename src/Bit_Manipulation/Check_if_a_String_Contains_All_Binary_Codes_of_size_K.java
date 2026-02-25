package Bit_Manipulation;
import java.util.*;
public class Check_if_a_String_Contains_All_Binary_Codes_of_size_K {
    public static boolean  hasAllCodes(String s, int k){
        HashSet<String> set = new HashSet<>();

        int n = s.length();

        int codes = 1 << k;   // power(2,k)

        for(int i = k; i <= n; i++){
            String sub = s.substring(i-k,i);

            if(!set.contains(sub)){
                set.add(sub);
                codes--;
            }

            if(codes == 0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "00110110";
        int k = 2;
        System.out.println(hasAllCodes(s,k));
    }
}

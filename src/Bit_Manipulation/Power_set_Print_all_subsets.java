package Bit_Manipulation;
import java.util.*;
public class Power_set_Print_all_subsets {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        int n = num.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < (1 << n);i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n;j++){
                if(( i & (1 << j)) != 0){ // check if the ith bit is set or not...
                    list.add(num[j]);
                }
            }
            ans.add(list);
        }
        System.out.println(ans);
    }
}

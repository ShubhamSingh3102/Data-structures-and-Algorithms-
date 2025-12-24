package HashMap;
import java.util.*;
public class Largest_subArray {
    static int zeroSumLargestSubArray(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        // prefixSum, index
        int maxLen = 0;
        int prefSum = 0;
        mp.put(0,-1);
        for(int i=0;i<arr.length;i++){
            prefSum += arr[i]; // calculating prefix Sum....
            if(mp.containsKey(prefSum)){
                maxLen = Math.max(maxLen, i - mp.get(prefSum));
            }
            else{
                mp.put(prefSum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int [] arr = {15,-2,2,-8,1,7,10};
        int n = zeroSumLargestSubArray(arr);
        System.out.println(n);
    }
}

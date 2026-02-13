package ARRAY;
import java.util.*;
public class Leetcode_1475 {
    public static int[] finalPrices(int[] prices){
        int[] ans = new int[prices.length];
        int n = prices.length;
        for(int i=0;i<n;i++){
            ans[i] = prices[i];
            for(int j=i+1;j<n;j++){
                if(prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(prices)));
    }
}

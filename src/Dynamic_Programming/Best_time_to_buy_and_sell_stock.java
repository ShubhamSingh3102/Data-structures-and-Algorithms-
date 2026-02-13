package Dynamic_Programming;
import java.util.*;
public class Best_time_to_buy_and_sell_stock {
    public static int maxProfit(int[] prices){
        int mini = prices[0];
        int maxProfit = 0;
        int n = prices.length;
        for(int i=0;i<n;i++){
            int cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit,cost);
            mini = Math.min(mini,prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

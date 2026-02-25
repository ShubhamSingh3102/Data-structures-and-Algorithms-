package Dynamic_Programming;
import java.util.*;
public class Best_time_to_buy_and_sell_stock_with_transaction_fees {
    // space optimized (prev & curr)
    public static int maxProfit(int[] prices,int fees) {
        int n = prices.length;

        int[] prev = new int[2]; // ahead
        int[] curr = new int[2]; // current

        for (int ind = n - 1; ind >= 0; ind--) {

            // buy = 1
            curr[1] = Math.max(-prices[ind] + prev[0],
                    prev[1]);

            // buy = 0
            curr[0] = Math.max((prices[ind] - fees ) + prev[1],
                    prev[0]);

            // shift
            prev = curr.clone();
        }

        return prev[1];
    }
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fees = 2;
        System.out.println(maxProfit(prices,fees));
    }
}

// Kya purani journey continue karu ya yahin se fresh start karu?”
// i --> best ending at i...

package Kadane_Algorithm;
import java.util.*;
public class Maximum_Sum_SubArray {
    public static int maximum_sum_subArray(int[] nums){
        int n = nums.length;

        int bestEnding = nums[0];
        int ans = nums[0];

        for(int i = 1; i < n; i++){
            int v1 = bestEnding + nums[i];  // purane waale se saath journey continue kr rhe h
            int v2 = nums[i];  // fresh start kr rha hu...
            bestEnding = Math.max(v1,v2);
            ans = Math.max(ans,bestEnding);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2};
        System.out.println(maximum_sum_subArray(nums));
    }
}













































// Sliding Window negative numbers me fail ho jaata hai
// because uska basic assumption toot jaata hai.
//
// Sliding Window assume karta hai:
//
// high++  -> sum increase hoga
// low++   -> sum decrease hoga
//
// Ye sirf positive numbers me true hota hai.
//
// But negative numbers me:
//
// high++ karne se sum increase bhi ho sakta hai
// aur decrease bhi ❌
//
// low++ karne se bhi sum increase/decrease
// dono ho sakta hai ❌
//
// Example:
// [-2, 5]
//
// -2 add kiya -> sum decrease ho gaya
// -2 remove kiya -> sum increase ho gaya
//
// Isliye Sliding Window decide nahi kar paata
// kab expand karna hai aur kab shrink.
//
// Kadane Algorithm me:
//
// Agar currentSum negative ho gaya,
// toh usko carry karne ka koi fayda nahi,
// because wo future sum ko hurt karega.
//
// Isliye:
//
// if(currentSum < 0)
//     currentSum = 0;
//
// Fir nayi subarray start karte hain.
package Sliding_Window;
import java.util.*;
public class Max_Sum_Subarray_of_size_k {
    // TC --> O(n)
    // SC --> O(1)
    public static int  maxSubarraySum(int[] arr, int k){
        int low = 0;    // starting....
        int high = k - 1;

        // starting ka information nikal lo...
        int sum = 0;
        for(int i = low; i <= high; i++){
            sum = sum + arr[i];
        }

        int res = Integer.MIN_VALUE;

        // window slide kro...
        while(high < arr.length){
            res = Math.max(res,sum);

            // shifting or sliding...
            low++;  // low - 1 chala gya
            high++;  // high add hogya

            // new window...
            if(high == arr.length){  // out of index
                break;
            }

            sum = sum - arr[low-1];

            sum = sum + arr[high];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {100,200,300,400};
        int k = 2; // fixed window problem....
        System.out.println(maxSubarraySum(arr,k));
    }
}













// For any questions of sliding window there are four steps
// 1 --> Identify patterns
// 2 --> Fixed window / Variable window
// 3 --> Find out data or information of the window
// 4 --> After sliding, find the new data or information of the new window
// Repeat and repeat
package Kadane_Algorithm;
import java.util.*;
public class Maximum_SubArray_Sum_with_one_Deletion {
    public static int maximumSum(int[] arr){
        int n = arr.length;

        // sirf ek bhi baar kisi element ko ignore kr skte ho...
        // hamare pass choice h isiliye hame purana dono data yaad rkhna hoga...isiliye two variable yaha use kiye...

        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int ans = arr[0];

        for(int i = 1; i < n; i++){
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            // power use nhi hua h...
            noDelete = Math.max(noDelete + arr[i],arr[i]);


            // power use hua h...
            int v2;
            if(prevOneDelete == Integer.MIN_VALUE){
                v2 = arr[i];
            } else {
                v2 = prevOneDelete + arr[i];
            }

            oneDelete = Math.max(v2,prevNoDelete);   // Math.max(v3,v4)

            ans = Math.max(ans,Math.max(noDelete,oneDelete));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,-2,0,3};
        System.out.println(maximumSum(arr));
    }
}




//// 4 steps hi tha...cases

// No power use.....
// 1 --> v1 = arr[i]
// 2 --> v2 = noPower + arr[i]

// Power use...
// 3 --> v3 = power + arr[i]
// 4 --> v4 = no power


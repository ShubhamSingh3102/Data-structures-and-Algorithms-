package HashMap;
import java.util.*;
public class Two_Sum {
    // TC--> 0(n^2)....
    //    static void Solution1(int[] arr,int target){
//        int n = arr.length;
//        boolean found = false;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                if(arr[i]+arr[j] == target){
//                    System.out.println(i + " and " + j);
//                    found = true;
//                    return;
//                }
//            }
//        }
//        if(!found){
//            System.out.println("Solution doesn't exists");
//        }
//    }

    // TC--> 0(n)....linear time
    static int[] Solution2(int[] arr, int target) {
        int n = arr.length;
        int[] ans = {-1};
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int partner = target - arr[i];
            if (mp.containsKey(partner)) {
                ans = new int[]{i, mp.get(partner)};
                return ans;
            }
            mp.put(arr[i], i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,5,4,1};
        int target = 4;
//        Solution1(arr,target);
        int[] result = Solution2(arr,target);
        if (result.length > 1) {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}

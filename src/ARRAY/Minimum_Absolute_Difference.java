package ARRAY;
import java.util.*;
public class Minimum_Absolute_Difference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr){

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        // Find minimum difference
        for(int i=1;i< arr.length;i++){
            int diff = arr[i] - arr[i-1];
            minDiff = Math.min(diff,minDiff);
        }



        // Collect pairs with minimum difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        System.out.println(minimumAbsDifference(arr));
    }
}



























//// Done by my own....
//package ARRAY;
//import java.util.*;
//public class Minimum_Absolute_Difference {
//    public static List<List<Integer>> minimumAbsDifference(int[] arr){
//        Arrays.sort(arr);
//
//        List<List<Integer>> result = new ArrayList<>();
//        int minDiff = Integer.MAX_VALUE;
//
//        // find minimum value first
//        for(int i = 1;i<arr.length;i++){
//            int diff = arr[i] - arr[i-1];
//            minDiff = Math.min(diff,minDiff);
//        }
//
//        // pair with minimum difference,..
//        for(int i=1;i<arr.length;i++){
//            int diff = arr[i] - arr[i-1];
//            if(diff == minDiff){
//                result.add(Arrays.asList(arr[i-1],arr[i]));
//            }
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        int[] arr = {4,2,1,3};
//        System.out.println(minimumAbsDifference(arr));
//    }
//}

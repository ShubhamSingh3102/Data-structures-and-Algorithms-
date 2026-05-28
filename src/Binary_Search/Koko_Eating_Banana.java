package Binary_Search;
import java.util.*;
public class Koko_Eating_Banana {
    public static long findHour(int[] piles,int speed){
        int n = piles.length;
        int hour = 0;
        for(int i = 0; i < n; i++){
            hour = hour + (piles[i] /speed);

            if(piles[i] % speed != 0){
                hour++;
            }
        }
        return hour;
    }
    public static int minEatingSpeed(int[] piles, int h){
        int n = piles.length;

        int low = 1;
        int high = piles[0];  // max of array...

        for(int i = 0; i < n; i++){
            high = Math.max(piles[i],high);
        }
        int res = -1;
        while(low<= high){
            int mid = low + (high - low) / 2;
            long hour = findHour(piles,mid);

            if(hour > h){   // no
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));
    }
}











//class Solution {
//    public long findHour(int[] piles, int speed){
//        long hour = 0;
//        for(int i = 0; i < piles.length; i++){
//            hour += (piles[i] + speed - 1) / speed;
//        }
//        return hour;
//    }
//
//    public int minEatingSpeed(int[] piles, int h){
//        int low = 1;
//        int high = piles[0];
//
//        for(int i = 0; i < piles.length; i++){
//            high = Math.max(high, piles[i]);
//        }
//
//        int res = high;
//
//        while(low <= high){
//            int mid = low + (high - low) / 2;
//            long hour = findHour(piles, mid);
//
//            if(hour > h){
//                low = mid + 1;
//            } else {
//                res = mid;
//                high = mid - 1;
//            }
//        }
//
//        return res;
//    }
//}
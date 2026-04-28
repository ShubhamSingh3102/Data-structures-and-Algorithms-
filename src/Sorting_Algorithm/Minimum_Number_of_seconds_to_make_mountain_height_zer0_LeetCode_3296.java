package Sorting_Algorithm;
import java.util.*;
public class Minimum_Number_of_seconds_to_make_mountain_height_zer0_LeetCode_3296 {
    public static boolean check(long mid,int[] workerTimes, int mH){
        long h = 0; // height to be reduced

        for(int t : workerTimes){
            h += (long)(Math.sqrt(2.0*mid/t + 0.25) - 0.5);

            if(h >= mH){
                return true;
            }
        }
        return h >= mH;
    }
    public static long minNumberOfSeconds(int mountainHeight,int[] workerTimes){
        int maxTime = 0;
        for(int t : workerTimes){
            maxTime = Math.max(maxTime,t);
        }

        long l = 1;
        long r = (long)maxTime * mountainHeight * (mountainHeight + 1) / 2;

        long result = 0;

        while(l <= r){
            long mid = l + (r - l) / 2;

            if(check(mid,workerTimes,mountainHeight)){
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int mountainHeight = 4;
        int[] workerTimes = {2,1,1};
        System.out.println(minNumberOfSeconds(mountainHeight,workerTimes));
    }
}

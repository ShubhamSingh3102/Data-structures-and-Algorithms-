package Merge_Intervals;
import java.util.*;
public class Check_Overlapping_Intervals {
    public static boolean check(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 >= start2){ // overlap
                return true;
            }
            start1 = start1;
            end1 = Math.max(end1,end2);
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},{5,7},{2,4},{6,8}
        };
        System.out.println(check(intervals));
    }
}

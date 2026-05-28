//package Merge_Intervals;
//import java.util.*;
//public class Insert_Interval {
//    public static int[][] insert(int[][] intervals,int[] newIntervals){
//        boolean insert = false;
//
//        ArrayList<int[]> res = new ArrayList<>();
//
//        for(int i = 0; i < intervals.length; i++){
//
//            // current interval newInterval se pehle hai
//            if(intervals[i][1] < newIntervals[0]){
//                res.add(intervals[i]);
//            }
//            // current interval newInterval ke baad hai
//            else if(intervals[i][0] > newIntervals[1]){
//                if(insert == false){
//                    res.add(newIntervals);
//                    insert = true;
//                }
//                res.add(intervals[i]);
//            }
//            // overlap h
//            else {
//                newIntervals[0] = Math.min(newIntervals[0],intervals[i][0]);
//                newIntervals[1] = Math.max(newIntervals[1],intervals[i][1]);
//            }
//        }
//        if(insert == false){
//            res.add(newIntervals);
//        }
//        return merge(res.toArray(new int[res.size()][]));
//    }
//    public static int[][] merge(int[][] intervals){
//        // sort on the basis of starting point
//        // positive means b pehle aayega and negative means a phele aaega
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//
//        ArrayList<int[]> ans = new ArrayList<>();
//
//        int start1 = intervals[0][0];
//        int end1 = intervals[0][1];
//
//        for(int i = 1; i < intervals.length; i++){
//
//            int start2 = intervals[i][0];
//            int end2 = intervals[i][1];
//
//            // overlap
//            if(end1 >= start2){
//
//                // merge
//                // [start1 , Math.max(end1, end2)]
//
//                start1 = start1;
//                end1 = Math.max(end1,end2);
//                continue;
//
//            } else {
//                // no overlap
//
//                ans.add(new int[]{start1,end1});
//
//                // update start1 and end1
//                start1 = start2;
//                end1 = end2;
//            }
//        }
//        // last interval add karna mat bhoolna
//        ans.add(new int[]{start1,end1});
//
//        return ans.toArray(new int[ans.size()][]);
//    }
//    public static void main(String[] args) {
//        int[][] intervals = {
//                {1,3},{3,5},{6,7},{8,10},{12,16}
//        };
//        int[] newInterval = {4,8};
//
//        int[][] ans = insert(intervals,newInterval);
//
//        for(int i = 0; i < ans.length; i++){
//            System.out.println(Arrays.toString(ans[i]));
//        }
//    }
//}

























package Merge_Intervals;
import java.util.*;
public class Insert_Interval {
    public static int[][] insert(int[][] intervals,int[] newIntervals){
        boolean insert = false;

        ArrayList<int[]> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(insert == false && intervals[i][0] > newIntervals[0]){
                res.add(newIntervals);
                insert = true;
            }
            res.add(intervals[i]);
        }
        if(insert == false){
            res.add(newIntervals);
        }
        return merge(res.toArray(new int[res.size()][]));
    }
    public static int[][] merge(int[][] intervals){
        // sort on the basis of starting point
        // positive means b pehle aayega and negative means a phele aaega
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList<>();

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            // overlap
            if(end1 >= start2){

                // merge
                // [start1 , Math.max(end1, end2)]

                start1 = start1;
                end1 = Math.max(end1,end2);
                continue;

            } else {
                // no overlap

                ans.add(new int[]{start1,end1});

                // update start1 and end1
                start1 = start2;
                end1 = end2;
            }
        }
        // last interval add karna mat bhoolna
        ans.add(new int[]{start1,end1});

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},{3,5},{6,7},{8,10},{12,16}
        };
        int[] newInterval = {4,8};

        int[][] ans = insert(intervals,newInterval);

        for(int i = 0; i < ans.length; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}

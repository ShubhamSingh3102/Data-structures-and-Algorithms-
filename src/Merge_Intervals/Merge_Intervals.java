package Merge_Intervals;
import java.util.*;
public class Merge_Intervals {
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
        int[][] intervals =  {
                {1,3},{2,6},{8,10},{15,18}
        };

        int[][] ans = merge(intervals);

        for(int i = 0; i < ans.length; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}

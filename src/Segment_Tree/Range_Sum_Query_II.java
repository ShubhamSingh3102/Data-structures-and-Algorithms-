package Segment_Tree;
import java.util.*;
public class Range_Sum_Query_II {
        public static void buildSegmentTree(int i,int l,int r,int[] segmentTree,int[] arr){
            if(l == r){
                segmentTree[i] = arr[r];
                return;
            }
            int mid = l + ( r - l ) / 2;
            buildSegmentTree(2*i+1,l,mid,segmentTree,arr);
            buildSegmentTree(2*i+2,mid+1,r,segmentTree,arr);
            segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
        }

        public static int querySegmentTree(int start, int end, int i, int l, int r, int[] segmentTree) {
            if (l > end || r < start) {
                return 0;
            }

            if (l >= start && r <= end) {
                return segmentTree[i];
            }

            int mid = l + (r - l) / 2;
            return querySegmentTree(start, end, 2 * i + 1, l, mid, segmentTree) +
                    querySegmentTree(start, end, 2 * i + 2, mid + 1, r, segmentTree);
        }

        List<Integer> querySum(int n,int[] arr, int q,int[] queries){
            int[] segmentTree = new int[4 * n];

            buildSegmentTree(0,0,n-1,segmentTree,arr);

            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < 2 * q; i+= 2){
                int start = queries[i] -1;  // Input is in 1-based indexing
                int end = queries[i+1] - 1; // Input is in 1-based indexing

                result.add(querySegmentTree(start,end,0,0,n-1,segmentTree));
            }
            return result;
        }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;

        int q = 2;
        int[] queries = {1,3, 2,4}; // (1,3) and (2,4)

        Range_Sum_Query_II obj = new Range_Sum_Query_II();

        List<Integer> result = obj.querySum(n,arr,q, queries);
        System.out.println(result);
    }
}

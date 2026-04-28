package Segment_Tree;
import java.util.*;
public class Range_Minimum_Query {
    // TC --> O(q * log n)
    // SC --> 0(4 * n)
    public static void buildSegmentTree(int i,int l,int r,int[] segmentTree,int[] arr){
        if(l == r){
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r -l) / 2;
        buildSegmentTree(2*i+1,l,mid,segmentTree,arr);
        buildSegmentTree(2*i+2, mid+1, r, segmentTree,arr);

        segmentTree[i] = Math.min(segmentTree[2*i+1], segmentTree[2*i+2]);
    }
    // Segment tree construction arr...
    public static int[] constructST(int[] arr,int n){
        int[] segmentTree = new int[4 * n];

        buildSegmentTree(0,0,n-1,segmentTree,arr);
        return segmentTree;
    }
    public static int querySegmentTree(int start,int end,int i,int l,int r,int[] segmentTree){
        // If the range is completely outside the current node range
        if(l > end || r < start){
            return Integer.MAX_VALUE;
        }
        // If the range is completely inside the current node range
        if(l >= start && r <= end){
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;
        return Math.min(querySegmentTree(start,end,2*i+1,l,mid,segmentTree),
                querySegmentTree(start,end,2*i+2,mid+1,r,segmentTree));
    }
    public static int RMQ(int[] segmentTree,int n,int l,int r){
        return querySegmentTree(l,r,0,0,n-1,segmentTree);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;

        int[] segmentTree = constructST(arr,n);

        int l = 0;
        int r = 2;
        System.out.println(RMQ(segmentTree,n,l,r));
    }
}

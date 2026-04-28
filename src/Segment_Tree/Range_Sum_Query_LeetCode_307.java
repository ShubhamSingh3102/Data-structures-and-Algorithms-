package Segment_Tree;
import java.util.*;
public class Range_Sum_Query_LeetCode_307 {
    static class NumArray{
        int[] tree;
        int n;

        public NumArray(int[] nums){
            n = nums.length;
            tree = new int[4 * n];
            build(nums,0,0,n-1);
        }
        public void build(int[] nums,int i,int l,int r){
            if(l == r){
                tree[i] = nums[r];
                return;
            }
            int mid = (l+r)/2;
            build(nums,2*i+1,l,mid);
            build(nums,2*i+2,mid+1,r);

            tree[i] = tree[2*i+1] + tree[2*i+2];
        }

        public void update(int index,int val){
            updateSegmentTree(index,val,0,0,n-1);
        }

        public void updateSegmentTree(int idx,int val,int i,int l,int r){
            if(l == r){
                tree[i] = val;
                return;
            }

            int mid = (l+r)/2;
            if(idx <= mid){  // left child
                updateSegmentTree(idx,val,2*i+1,l,mid);
            } else {   // right child
                updateSegmentTree(idx,val,2*i+2,mid+1,r);
            }
            tree[i] = tree[2*i+1] + tree[2*i+2];
        }

        public int sumRange(int start,int end){
            return query(start,end,0,0,n-1);
        }

        public int query(int start,int end,int i,int l,int r){
            if(l > end || r < start){    // out of bound
                return 0;
            }
            if(l >= start && r <= end){
                return tree[i];
            }
            int mid = (l+r)/2;

            int leftSum = query(start,end,2*i+1,l,mid);
            int rightSum = query(start,end,2*i+2,mid+1,r);

            return leftSum + rightSum;
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2,7,2,1,2,3};
        NumArray obj = new NumArray(nums);
        System.out.println("Sum (2,6): " + obj.sumRange(2,6));

        obj.update(2,4);

        System.out.println("After update:");
        System.out.println("Sum (2,6): " + obj.sumRange(2,6));
    }
}




//// Why size of array is 4*n
// Segment tree is a binary tree.....
// if n is not a power of 2 we have to append some dummy/extra nodes.....(of next nearest power of 2)....so that it can be
// paired up further...
// we make approximately (2*n) leaf nodes....
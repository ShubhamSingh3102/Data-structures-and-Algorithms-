package LeetCode_DPQ;
import java.util.*;
// You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.
//
//From left to right, place the fruits according to these rules:
//
//Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
//Each basket can hold only one type of fruit.
//If a fruit type cannot be placed in any basket, it remains unplaced.
//Return the number of fruit types that remain unplaced after all possible allocations are made.
//
//
//
//Example 1:
//
//Input: fruits = [4,2,5], baskets = [3,5,4]
//
//Output: 1
//
//Explanation:
//
//fruits[0] = 4 is placed in baskets[1] = 5.
//fruits[1] = 2 is placed in baskets[0] = 3.
//fruits[2] = 5 cannot be placed in baskets[2] = 4.
//Since one fruit type remains unplaced, we return 1.
//
//Example 2:
//
//Input: fruits = [3,6,1], baskets = [6,4,7]
//
//Output: 0
//
//Explanation:
//
//fruits[0] = 3 is placed in baskets[0] = 6.
//fruits[1] = 6 cannot be placed in baskets[1] = 4 (insufficient capacity) but can be placed in the next available basket, baskets[2] = 7.
//fruits[2] = 1 is placed in baskets[1] = 4.
//Since all fruits are successfully placed, we return 0.
//
//
//
//Constraints:
//
//n == fruits.length == baskets.length
//1 <= n <= 105
//1 <= fruits[i], baskets[i] <= 109

// Concept of segment Tree
public class Fruits_Into_BasketsIII_LeetCode_3479 {

    // building of Segment Tree.....
    void build(int i, int l, int r, List<Integer> baskets, int[] segmentTree) {
        if (l == r) {
            segmentTree[i] = baskets.get(l);
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * i + 1, l, mid, baskets, segmentTree);
        build(2 * i + 2, mid + 1, r, baskets, segmentTree);

        segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
    }

    // Query the Segment Tree to find a basket for the current fruit.....
    boolean querySegmentTree(int i, int l, int r, int[] segmentTree, int fruit) {
        if (segmentTree[i] < fruit) {
            return false; // No basket in this segment can hold the fruit
        }

        if (l == r) {
            segmentTree[i] = -1; // Assign fruit to this basket, mark used....occupied
            return true;
        }

        int mid = l + (r - l) / 2;
        boolean placed = false;

        if (segmentTree[2 * i + 1] >= fruit) { // left side....
            placed = querySegmentTree(2 * i + 1, l, mid, segmentTree, fruit);
        } else { // right side...segmentTree[2 * i + 1] < fruit
            placed = querySegmentTree(2 * i + 2, mid + 1, r, segmentTree, fruit);
        }

        segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]); // Update current node
        return placed;
    }

    // Main function to calculate unplaced fruits.....
    public int numOfUnplacedFruits(List<Integer> fruits, List<Integer> baskets) {
        int n = baskets.size();

        // Initialize segment tree.....
        int[] segmentTree = new int[4 * n];
        Arrays.fill(segmentTree, -1);

        build(0, 0, n - 1, baskets, segmentTree);

        int unplaced = 0;

        for (int fruit : fruits) {
            boolean placed = querySegmentTree(0, 0, n - 1, segmentTree, fruit);
            if (!placed) {
                unplaced++;
            }
        }

        return unplaced;
    }

    public static void main(String[] args) {
        Fruits_Into_BasketsIII_LeetCode_3479 sol = new Fruits_Into_BasketsIII_LeetCode_3479();

        List<Integer> fruits = Arrays.asList(4, 2, 5);
        List<Integer> baskets = Arrays.asList(3, 5, 4);

        int result = sol.numOfUnplacedFruits(fruits, baskets);
        System.out.println("Unplaced Fruits = " + result);
    }
}

package LeetCode_DPQ;
// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//
//You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//
//You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//Given the integer array fruits, return the maximum number of fruits you can pick.
//
//
//
//Example 1:
//
//Input: fruits = [1,2,1]
//Output: 3
//Explanation: We can pick from all 3 trees.
//Example 2:
//
//Input: fruits = [0,1,2,2]
//Output: 3
//Explanation: We can pick from trees [1,2,2].
//If we had started at the first tree, we would only pick from trees [0,1].
//Example 3:
//
//Input: fruits = [1,2,3,2,2]
//Output: 4
//Explanation: We can pick from trees [2,3,2,2].
//If we had started at the first tree, we would only pick from trees [1,2]....

import java.util.*;

public class Fruits_into_baskets_LeetCode_904 {

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, maxFruits = 0;
        int n =  fruits.length;
        while (j < n) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1); // If fruits[j] exists in the map → returns its count.
            // If not → returns 0 as default and  increase the count by 1....

            if (map.size() <= 2) {
                maxFruits = Math.max(maxFruits, j - i + 1);
            } else {
                while (map.size() > 2) {
                    map.put(fruits[i], map.get(fruits[i]) - 1); // mp[fruits[i]]--; // frequency kaam kr do....
                    if (map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }
                    i++;
                }
            }
            j++;
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        Fruits_into_baskets_LeetCode_904 obj = new Fruits_into_baskets_LeetCode_904();

        int[] fruits1 = {1, 2, 1};
        int[] fruits2 = {0, 1, 2, 2};
        int[] fruits3 = {1, 2, 3, 2, 2};

        System.out.println("Output 1: " + obj.totalFruit(fruits1)); // 3
        System.out.println("Output 2: " + obj.totalFruit(fruits2)); // 3
        System.out.println("Output 3: " + obj.totalFruit(fruits3)); // 4
    }
}

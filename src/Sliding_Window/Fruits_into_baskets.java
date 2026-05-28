package Sliding_Window;
import java.util.*;
//// at most 2 distinct types of fruits nikalna hai...
/// max no of fruits kitna collect kr skte ho...
/// find longest substring which has at most 2 distinct numbers...
public class Fruits_into_baskets {
    public static int totalFruit(int[] fruits){
        HashMap<Integer,Integer> map = new HashMap<>();

        // TC --> O(n)
        // SC --> O(k)
        // Variable Sliding Window...
        int low = 0;
        int high = 0;

        int result = Integer.MIN_VALUE;

        while(high < fruits.length){
            // include current fruit
            map.put(fruits[high], map.getOrDefault(fruits[high],0) + 1);

            // if map ka size == k ho jaaye then information ekdam sahi ho jayega...
            // ya information galat ho jaaye....map.size > k or map.size < k
            // map.size < k already kaam h then usko shrink krke aur kaam kyu krna hai....
            // map.size > k low ko badhana hai...window shrink krna hai....
            while(map.size() > 2){
                // low ko badhao...window size decrease kro...

                map.put(fruits[low], map.get(fruits[low]) -1);

                if(map.get(fruits[low]) == 0){
                    // now remove it from the map;
                    map.remove(fruits[low]);
                }
                low++;
            }
            // now 2 cases....map.size == k or map.size < k
            int length = high - low + 1;
            result = Math.max(length,result);
            high++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
}

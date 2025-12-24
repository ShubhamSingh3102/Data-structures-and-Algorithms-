package HashMap;
import java.util.*;
public class Most_frequent_element {
    static void frequentElement(int[] arr){
        // Time Complexity : O(n)....
        Map<Integer,Integer> freq = new HashMap<>();
        for(int el : arr){
            if(!freq.containsKey(el)){
                freq.put(el,1);
            }
            else{
                freq.put(el, freq.get(el)+1);
            }
        }
        System.out.println("Frequency Map");
        System.out.println(freq.entrySet());
        int maxFreq = -1;
        int ansKey = -1;
        for(var e : freq.entrySet()){
            if(e.getValue() > maxFreq){
                maxFreq = e.getValue();
                ansKey = e.getKey();
            }
        }
        System.out.printf("%d has maximum frequency of %d",ansKey,maxFreq);
    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,1,4,4,6,4,4,4,6,2,2};
        frequentElement(arr);
    }
}

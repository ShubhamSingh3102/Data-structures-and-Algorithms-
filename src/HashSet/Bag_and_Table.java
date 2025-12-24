package HashSet;
import java.util.*;
public class Bag_and_Table {
    static int maxNumberOnTable(int[] bag){
        HashSet<Integer> table = new HashSet<>();
        int max = 0;
        for(int i=0;i< bag.length;i++){
            int num = bag[i];
            if(table.contains(num)){ // table pe ye number ka pair exist karta hai...
                table.remove(num);
            }
            else{
                table.add(num);
                max = Math.max(max,table.size());
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] bag = {2,1,1,3,2,3};
        int result = maxNumberOnTable(bag);
        System.out.println(result);
    }
}

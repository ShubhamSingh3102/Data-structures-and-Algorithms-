package Simulated_Problem;
import java.util.*;
public class Count_Collisions_on_a_Road {
    public static int countCollisions(String directions){
        int n = directions.length();

        int i = 0; // left boundary
        while(i < n && directions.charAt(i) == 'L'){
            i++; // skip
        }

        int j = n - 1;
        while(j >= 0 && directions.charAt(j) == 'R'){
            j--; // skip
        }

        int collisions = 0;
        while(i <= j){
            if(directions.charAt(i) != 'S'){
                collisions ++;
            }
            i++;
        }
        return collisions;
    }
    public static void main(String[] args) {
        String directions = "LLRLRSLRR";
        System.out.println(countCollisions(directions));
    }
}

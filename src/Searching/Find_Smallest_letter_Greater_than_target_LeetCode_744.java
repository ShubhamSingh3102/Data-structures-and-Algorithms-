package Searching;
import java.util.*;
public class Find_Smallest_letter_Greater_than_target_LeetCode_744 {
    public static char nextGreaterLetter(char[] letters,char target){
        int n = letters.length;

        int l = 0;
        int r = n - 1;
        int mid;
        int pos = -1;

        while(l <= r){
            mid = l + (r-l)/2;

            if(letters[mid] > target){
                pos = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if(pos == -1){
            return letters[0];
        }
        return letters[pos];
    }
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreaterLetter(letters,target));
    }
}

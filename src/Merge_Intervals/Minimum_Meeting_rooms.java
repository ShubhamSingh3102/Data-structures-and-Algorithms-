package Merge_Intervals;
import java.util.*;
public class Minimum_Meeting_rooms {
    public static int minMeetingRooms(int[] start,int[] end){
        int room = 0;
        int ans = 0;

        // sort kr do phele dono ko
        Arrays.sort(start);
        Arrays.sort(end);

        // time ke hisab se dekhte hai...
        int i = 0;
        int j = 0;

        // start phele khatam hoga...
        while(i < start.length && j < end.length){
            if(start[i] < end[j]){
                room++;
                ans = Math.max(ans,room);
                i++;
            } else if(start[i] == end[j]){   // phele khali kr deta phir room add kro
                room--;
                j++;
            } else {
                room--;
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] start = {1,10,7};
        int[] end = {4,15,10};
        System.out.println(minMeetingRooms(start,end));
    }
}







// 1 --> room chahiye
// 4 --> room khali kr do
// 7 --> room chahiye
// 10 --> room khali kr do
// 10 --> room chahiye
// 15 --> room khali kr do

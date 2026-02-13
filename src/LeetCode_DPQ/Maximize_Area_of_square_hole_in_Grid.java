package LeetCode_DPQ;
import java.util.*;
public class Maximize_Area_of_square_hole_in_Grid {
    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxH = 1, currH = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - hBars[i - 1] == 1) {
                currH++;
            }
            else {
                currH = 1;
            }
            maxH = Math.max(maxH, currH);
        }

        int maxV = 1, currV = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] - vBars[i - 1] == 1) {
                currV++;
            }
            else {
                currV = 1;
            }
            maxV = Math.max(maxV, currV);
        }

        int side = Math.min(maxH, maxV) + 1;
        return side * side;
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 1;
        int[] hBars = {2,3}; // sirf ye wala hata sakta hai....
        int[] vBars = {2};  // sirf ye wala hata sakta hai...
        System.out.println(maximizeSquareHoleArea(n,m,hBars,vBars));
    }
}

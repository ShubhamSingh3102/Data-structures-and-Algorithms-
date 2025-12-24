package ARRAY;
import java.util.*;
public class Container_with_most_water {
    public int maxArea(int[] height){
        int n = height.length;
        int i = 0;
        int j = n-1;
        int maxWater = 0;
        while(i<j){
            int weight = j-i;
            int h = Math.min(height[i],height[j]);
            int area = weight * h;
            maxWater = Math.max(maxWater,area);
            if(height[i] > height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Container_with_most_water obj = new Container_with_most_water();
        System.out.println(obj.maxArea(height));
    }
}

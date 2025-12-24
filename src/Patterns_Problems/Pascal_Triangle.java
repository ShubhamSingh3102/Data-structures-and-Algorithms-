package Patterns_Problems;
import java.util.*;
public class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements of each row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Add values from the previous row: above-left + above-right
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
    public static void main(String[] args) {
        Pascal_Triangle pt = new Pascal_Triangle();
        List<List<Integer>> result = pt.generate(5); // example: 5 rows

        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}

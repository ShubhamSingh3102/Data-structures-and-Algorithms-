package Codeforce_Practice_Question;
import java.util.*;
public class Restoring_Three_Numbers {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] a = new int[4];
            for (int i = 0; i < 4; i++) {
                a[i] = sc.nextInt();
            }
            int max = a[0];
            for (int i = 1; i < 4; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            for (int i = 0; i < 4; i++) {
                if (a[i] != max) {
                    System.out.print((max - a[i]) + " ");
                }
            }
        }
    }
}
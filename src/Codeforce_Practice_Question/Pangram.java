package Codeforce_Practice_Question;
import java.util.*;
public class Pangram {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.print("Enter the string: ");
            String str = sc.next().toLowerCase();

            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    map.put(ch, 1);
                }
            }

            if (map.size() == 26)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

package Conversion_problem;
import java.util.Scanner;
public class Decimal_to_Binary {
    public Decimal_to_Binary(int n) {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the decimal number: ");
        int decimal = sc.nextInt();

        int ans = 0; //converted binary number
        int pw = 1; // power of 10

        while(decimal > 0){
            int parity = decimal % 2;
            ans = ans + (parity * pw);
            pw = pw*10;
            decimal = decimal / 2;
        }
        System.out.println(ans);
    }
}

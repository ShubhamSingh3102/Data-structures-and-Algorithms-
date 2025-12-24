package Strings;
public class Performance {
    public static void main(String[] args) {
        String str = " ";
        for(int i=1;i<=10;i++){
            str = str + i;
        }
        // "" "1" "12" "123" "1234" "12345"
        System.out.println(str);
    }
}

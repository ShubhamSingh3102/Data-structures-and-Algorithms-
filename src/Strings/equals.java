package Strings;
public class equals {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello"); // alag address ko point kr rha hai...

        // sees only address
        System.out.println(s1==s2);
        System.out.println(s1==s3);

        // f\sees full string
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}

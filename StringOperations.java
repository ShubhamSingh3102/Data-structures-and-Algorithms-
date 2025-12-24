import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Change the case of the string
        System.out.print("Enter a String: ");
        String inputString = scanner.nextLine();
        String changedCaseString = changeCase(inputString);
        System.out.println("The string after changing the case is: " + changedCaseString);

        // Reverse the string
        String reversedString = reverseString(inputString);
        System.out.println("The string after reversing is: " + reversedString);

        // Compare two strings
        System.out.print("Enter the second string for comparison: ");
        String secondString = scanner.nextLine();
        int asciiDifference = compareStrings(inputString, secondString);
        System.out.println("The difference between ASCII values is: " + asciiDifference);

        // Insert one string into another
        System.out.print("Enter the string to be inserted into the first string: ");
        String stringToInsert = scanner.nextLine();
        String insertedString = insertString(inputString, stringToInsert);
        System.out.println("The string after insertion is: " + insertedString);

        // Convert the string to upper case and lower case
        System.out.println("Uppercase: " + inputString.toUpperCase());
        System.out.println("Lowercase: " + inputString.toLowerCase());

        // Check if the character is present in the string and at which position
        System.out.print("Enter a character: ");
        char charToCheck = scanner.next().charAt(0);
        checkCharacter(inputString, charToCheck);

        // Check if the string is a palindrome
        boolean isPalindrome = checkPalindrome(inputString);
        System.out.println("Entered string is " + (isPalindrome ? "a palindrome" : "not a palindrome"));

        // Check the number of words, vowels, and consonants in the string
        int wordCount = countWords(inputString);
        int vowelCount = countVowels(inputString);
        int consonantCount = countConsonants(inputString);
        System.out.println("No. of words: " + wordCount);
        System.out.println("No. of vowels: " + vowelCount);
        System.out.println("No. of consonants: " + consonantCount);

        scanner.close();
    }

    private static String changeCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static int compareStrings(String str1, String str2) {
        int asciiDifference = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            asciiDifference += Math.abs(str1.charAt(i) - str2.charAt(i));
        }
        return asciiDifference;
    }

    private static String insertString(String original, String toInsert) {
        return original + " " + toInsert;
    }

    private static void checkCharacter(String str, char c) {
        int index = str.indexOf(c);
        if (index != -1) {
            System.out.println("Position of entered character: " + index);
        } else {
            System.out.println("Entered character is not present");
        }
    }

    private static boolean checkPalindrome(String str) {
        String reversedStr = reverseString(str);
        return str.equals(reversedStr);
    }

    private static int countWords(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        String[] words = str.split("\\s+");
        return words.length;
    }

    private static int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    private static int countConsonants(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c) && !isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

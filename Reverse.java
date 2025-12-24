import java.util.Scanner;
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the sentence from the user
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Reverse the entire string
        String reversedString = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed entire string: " + reversedString);

        // Reverse the words in the string
        String reversedWords = reverseWords(input);
        System.out.println("Reversed words in the string: " + reversedWords);

        // Reverse the characters within each word
        String reverseCharsInWords = reverseCharsInWords(input);
        System.out.println("Reversed characters within each word: " + reverseCharsInWords);

        // Reverse the characters within each word and then reverse the order of words
        String reverseCharsAndWords = reverseCharsAndWords(input);
        System.out.println("Reversed characters within words and then reversed order of words: " + reverseCharsAndWords);

        scanner.close();
    }

    // Helper method to reverse words in the string
    private static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reversedWords = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedWords.append(words[i]).append(" ");
        }

        return reversedWords.toString().trim();
    }

    // Helper method to reverse characters within each word
    private static String reverseCharsInWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reversedCharsInWords = new StringBuilder();

        for (String word : words) {
            reversedCharsInWords.append(new StringBuilder(word).reverse().toString()).append(" ");
        }

        return reversedCharsInWords.toString().trim();
    }

    // Helper method to reverse characters within each word and then reverse the order of words
    private static String reverseCharsAndWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reversedCharsAndWords = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedCharsAndWords.append(new StringBuilder(words[i]).reverse().toString()).append(" ");
        }

        return reversedCharsAndWords.toString().trim();
    }
}
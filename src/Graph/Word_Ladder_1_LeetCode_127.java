package Graph;
import java.util.*;
public class Word_Ladder_1_LeetCode_127 {
    class Pair {
        String first;
        int second;
        Pair(String _first,int _second) {
            this.first = _first;
            this.second = _second;
        }
    }
    public int wordLadderLength(String startWord,String targetWord,String[] wordlist) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String> st = new HashSet<String>();
        int len = wordlist.length;
        for(int i=0;i<len;i++) {
            st.add(wordlist[i]);
        }
        st.remove(startWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(targetWord)) { // means true
                return steps;
            }
            // word = hat

            // TC --> word.length * 26 * N * TC(Set)
            // SC --> O(N)
            for(int i=0;i<word.length();i++) {
                for(char ch = 'a';ch <= 'z';ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    // if it exists in the set

                    if(st.contains(replacedWord)) { // means true
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0; // didn't find....
    }
    public static void main(String[] args) {
        Word_Ladder_1_LeetCode_127 obj = new Word_Ladder_1_LeetCode_127();

        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = obj.wordLadderLength(startWord, targetWord, wordList);
        System.out.println("Shortest transformation sequence length: " + result);
    }
}

package Graph;
import java.util.*;
public class Word_Ladder_2_Optimised_Approach_LeetCode_126 {
    static class Solution {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();

        private void dfs(String word, String beginWord, List<String> seq) {
            // If we reached the starting word
            if (word.equals(beginWord)) {
                List<String> temp = new ArrayList<>(seq);
                Collections.reverse(temp);
                ans.add(new ArrayList<>(temp));
                return;
            }

            int steps = mp.get(word);
            int len = word.length();

            // Try replacing every character
            for (int i = 0; i < len; i++) {
                char[] replacedCharArray = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (mp.containsKey(replacedWord) && mp.get(replacedWord) + 1 == steps) {
                        seq.add(replacedWord);
                        dfs(replacedWord, beginWord, seq);
                        seq.remove(seq.size() - 1);
                    }
                }
            }
        }

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> st = new HashSet<>(wordList);

            Queue<String> q = new LinkedList<>();
            q.add(beginWord);
            st.remove(beginWord);
            mp.put(beginWord, 1);

            int wordLen = beginWord.length();

            // BFS to build levels
            while (!q.isEmpty()) {
                String word = q.peek();
                q.remove();
                int steps = mp.get(word);

                if (word.equals(endWord)) break;

                for (int i = 0; i < wordLen; i++) {
                    char[] replacedCharArray = word.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        replacedCharArray[i] = ch;
                        String replacedWord = new String(replacedCharArray);

                        if (st.contains(replacedWord)) {
                            q.add(replacedWord);
                            st.remove(replacedWord);
                            mp.put(replacedWord, steps + 1);
                        }
                    }
                }
            }

            if (mp.containsKey(endWord)) {
                List<String> seq = new ArrayList<>();
                seq.add(endWord);
                dfs(endWord, beginWord, seq);
            }

            return ans;
        }
        // Example test
        public static void main(String[] args) {
            Solution sol = new Solution();
            List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
            System.out.println(sol.findLadders("hit", "cog", wordList));
        }
    }
}

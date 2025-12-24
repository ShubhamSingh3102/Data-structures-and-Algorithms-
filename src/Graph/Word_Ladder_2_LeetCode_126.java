package Graph;
import java.util.*;

public class Word_Ladder_2_LeetCode_126 {

    // TC --> O(N * L * 26) → O(N * L)
    // sc --> O(N * L * number_of_paths)
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> st = new HashSet<>();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
            q.remove();

            // remove words used in previous levels
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            if (word.equals(targetWord)) {
                if (ans.size() == 0) {
                    ans.add(new ArrayList<>(vec));
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(new ArrayList<>(vec));
                }
            }

            for (int i = 0; i < word.length(); i++) {
                char[] replacedCharArray = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String startWord = "der";
        String targetWord = "dfs";
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        ArrayList<ArrayList<String>> sequences = findSequences(startWord, targetWord, wordList);
        for (ArrayList<String> seq : sequences) {
            System.out.println(seq);
        }
    }
}

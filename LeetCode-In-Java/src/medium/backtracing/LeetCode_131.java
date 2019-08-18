package medium.backtracing;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> tmpList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tmpList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (palindrome(s, start, i)) {
                    tmpList.add(s.substring(start, i + 1));
                    backtrack(result, tmpList, s, i + 1);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }

    public boolean palindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode_131 leetCode_131 = new LeetCode_131();
        System.out.println(leetCode_131.partition("aab"));
    }
}

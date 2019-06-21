package medium.string;

public class LeetCode_647 {

    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] bb = new boolean[len][len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if ((s.charAt(i) == s.charAt(j)) && (i - j < 2 || bb[i - 1][j + 1])) {
                    bb[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }
}

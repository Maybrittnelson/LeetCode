package hard.dynamic;

public class LeetCode_132 {

    public int minCut(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int[] cut = new int[str.length()];
        boolean[][] isPal = new boolean[str.length()][str.length()];
        for (int i = 1; i < str.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
                    isPal[i][j] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
                }
            }
            cut[i] = min;
        }
        return cut[str.length() - 1];
    }

    public static void main(String[] args) {
        LeetCode_132 leetCode_132 = new LeetCode_132();
        System.out.println(leetCode_132.minCut("abcbm"));
    }
}

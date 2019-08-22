package medium.dynamic;

public class LeetCode_62 {

    public int uniquePaths(int m, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[j] += result[j - 1];
            }
        }

        return result[n - 1];
    }

}

package medium.dynamic;

public class LeetCode_96 {

    public int numTrees(int n) {
        int[] cnt = new int[n + 1];
        cnt[0] = cnt[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                cnt[i]+=cnt[j]*cnt[i-j-1];
            }
        }

        return cnt[n];
    }
}

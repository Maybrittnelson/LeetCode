package medium.backtracing;

public class LeetCode_60 {

    private int N;
    private int k;
    private String ans;

    public String getPermutation(int n, int k) {
        this.N = n;
        this.k = k;

        backtrack(new boolean[n + 1], "");
        return ans;
    }

    private void backtrack(boolean[] used, String prefix) {
        if (prefix.length() == N) {
            if (k == 1) {
                ans = prefix;
            }
            k--;
            return;
        }

        if (ans != null) {
            return;
        }

        for (int j = 1; j <= N; j++) {
            if (!used[j]) {
                used[j] = true;
                backtrack(used, prefix + j);
                System.out.println(prefix +"："+j);
                used[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_60 leetCode_60 = new LeetCode_60();
        String permutation = leetCode_60.getPermutation(4, 9);
        System.out.println(permutation);
    }

}

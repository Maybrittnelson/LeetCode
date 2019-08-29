package medium.backtracing;

import java.math.BigInteger;

public class LeetCode_306 {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }

            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }

                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if (isValid(num, x1, x2, i + j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(String num, BigInteger x1, BigInteger x2, int start) {
        if (start == num.length()) {
            return true;
        }

        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(num, x1, x2, start + sum.length());
    }

    public static void main(String[] args) {
        LeetCode_306 leetCode_306 = new LeetCode_306();
        leetCode_306.isAdditiveNumber("199100199");
    }
}

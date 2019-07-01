package medium.string;

public class LeetCode_8 {

    public int myAtoi(String str) {
        int i = 0, j = 0, len = str.length();
        boolean negative = false;
        for (i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (isDigit(c)) {
                break;
            } else if (c == '-' || c == '+') {
                negative = c == '-';
                i++;
                break;
            } else if (c != ' ') {
                return 0;
            }
        }

        for (j = i; j < len; j++) {
            if (!isDigit(str.charAt(j))) {
                break;
            }
        }

        int ret = 0;
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE/10 || ret == Integer.MAX_VALUE/10 && cur> 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret*10 + cur;
            }
        }
        return ret;
    }

    public boolean isDigit(char c) {
        if (c < '0' || '9' < c) {
            return false;
        }
        return true;
    }
}

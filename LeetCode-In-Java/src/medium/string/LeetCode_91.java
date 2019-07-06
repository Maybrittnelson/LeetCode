package medium.string;

public class LeetCode_91 {

    public int check(char ch) {
        return (!Character.isDigit(ch) || ch == '0') ? 0 : 1;
    }

    public int check(char ch1, char ch2) {
        //check 10~26
        return (ch1 == '1' || (ch1 == '2' && ch2 <= '6')) ? 1 : 0;
    }



    public int numDecoding(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        if (s.length() == 1) {
            return check(s.charAt(0));
        }

        int[] dp = new int[s.length()];

        dp[0] = check(s.charAt(0));
        dp[1] = check(s.charAt(0)) * check(s.charAt(1)) + check(s.charAt(0), s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            if (check(s.charAt(i)) == 1) {
                dp[i] = dp[i - 1];
            }
            if (check(s.charAt(i - 1), s.charAt(i)) == 1) {
                dp[i] += dp[i - 2];
            }
        }
        int result = dp[s.length() - 1];
        return result;
    }

    /*  an other solution on recursion
    public int numDecodings(String s) {
        if(s == null) {
            return 0;
        }
        Integer[] memo = new Integer[s.length()+1];
        return numDecoding(s, s.length(), memo);
    }


    public int numDecoding(String s, int k, Integer[] memo) {
        if(k == 0) {
            return 1;
        }
        if(memo[k] != null) {
            return memo[k];
        }

        int i = s.length() - k;
        if(s.charAt(i) == '0') {
            return 0;
        }

        int result = numDecoding(s, k-1, memo);
        if(k >= 2 && Integer.parseInt(s.substring(i, i+2)) <=26) {
            result += numDecoding(s, k-2, memo);
        }
        memo[k] = result;
        return result;
    }*/
}

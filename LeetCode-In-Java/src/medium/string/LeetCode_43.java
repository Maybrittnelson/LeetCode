package medium.string;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/4
 */
public class LeetCode_43 {

    public String multiply(String num, char ch) {
        int n = ch - '0';
        int carry = 0;
        String s = "";
        int x;
        for (int i = num.length() - 1; i >= 0; i--) {
            x = (num.charAt(i) - '0') * n + carry;
            carry = x / 10;
            int tmp = (x % 10);
            s = tmp + s;
        }

        if (carry > 0) {
            int tmp = carry ;
            s = tmp + s;
        }
        return s;
    }

    public String multiply(String num1, String num2) {

        if (num1.length() <= 0 || num2.length() <= 0) {
            return "";
        }

        int shift = 0;
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            String s = multiply(num2, num1.charAt(i));
            for (int j = 0; j < shift; j++) {
                s += '0';
            }
            result = strPlus(result, s);
            shift++;
        }
        if (result.charAt(0) == '0') return "0";
        return result;
    }

    public String strPlus(String num1, String num2) {
        String s = "";
        int carry = 0;
        int x = 0;
        int n1 = num1.length();
        int n2 = num2.length();

        int i, j;
        for (i = n1 - 1, j = n2 - 1; i >= 0 || j >= 0; i--, j--) {
            int x1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int x2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            x = x1 + x2 + carry;
            carry = x / 10;
            int tmp = x % 10 ;
            s = tmp + s;
        }
        if (carry > 0) {
            int tmp = carry ;
            s = tmp + s;
        }
        return s;
    }


    public static void main(String[] args) {
        LeetCode_43 solution = new LeetCode_43();
        String multiply = solution.multiply("20", "30");
        System.out.println(multiply);
    }
}

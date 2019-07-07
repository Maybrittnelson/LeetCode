package medium.string;

import java.util.Arrays;

public class LeetCode_151 {

    public String reverseWords(String s) {
        String[] words = s.split(" ");

        int i = 0;
        int j = words.length - 1;
        for (; i < j; i++, j--) {
            String tmp = words[i];
            words[i] = words[j];
            words[j] = tmp;
        }

        words = Arrays.stream(words).filter(it -> (it != null && it.length() > 0)).toArray(String[]::new);
        String result = String.join(" ", words);
        return result;
    }

    public static void main(String[] args) {
        LeetCode_151 leetCode_151 = new LeetCode_151();
        System.out.println(leetCode_151.reverseWords(" hello world! "));
    }
}

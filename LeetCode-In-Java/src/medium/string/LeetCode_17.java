package medium.string;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_17 {

    public List<String> letterCombinations(String digits) {
        char[][] phone = {{' ', '\0', '\0', '\0'},
                {'\0', '\0', '\0', '\0'},
                {'a', 'b', 'c', '\0'},
                {'d', 'e', 'f', '\0'},
                {'g', 'h', 'i', '\0'},
                {'j', 'k', 'l', '\0'},
                {'m', 'n', 'o', '\0'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v', '\0'},
                {'w', 'x', 'y', 'z'}};

        List<String> result = new ArrayList<>();
        if (digits.length() <= 0) {
            return result;
        }

        for (int i = 0; i < digits.length(); i++) {
            char curChar = digits.charAt(i);
            if (curChar < 0 || curChar > '9') {
                return result;
            }

            int d = curChar - '0';
            if (result.size() <= 0) {
                for (int j = 0; j < 4 && phone[d][j] != '\0'; j++) {
                    String s = "";
                    s += phone[d][j];
                    result.add(s);
                }
                continue;
            }

            List<String> list = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < 4 && phone[d][k] != '\0'; k++) {
                    String s = result.get(j) + phone[d][k];
                    list.add(s);
                }
            }
            result = list;
        }
        return result;
    }
}

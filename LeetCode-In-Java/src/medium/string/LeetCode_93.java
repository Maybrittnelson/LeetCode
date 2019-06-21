package medium.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_93 {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();

    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : m == 1;
    }

    public void update_output(int cur_pos) {
        String segment = s.substring(cur_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public void backtrack(int prev_pos, int dots) {
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int cur_pos = prev_pos + 1; cur_pos < max_pos; cur_pos++) {
            String segment = s.substring(prev_pos + 1, cur_pos + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0) {
                    update_output(cur_pos);
                } else {
                    backtrack(cur_pos, dots - 1);
                }
                segments.removeLast();
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        this.n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

    public static void main(String[] args) {
        LeetCode_93 leetCode_93 = new LeetCode_93();
        leetCode_93.restoreIpAddresses("25525511134");
    }
}

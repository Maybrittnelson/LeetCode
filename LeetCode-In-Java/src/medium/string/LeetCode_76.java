package medium.string;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/6/27
 */
public class LeetCode_76 {

    public static String minWindow(String s, String t) {
        String win = "";
        if (s == null || s.length() < 1
                || t == null || t.length() < 1 || s.length() < t.length()) {
            return win;
        }

        int MAX_CHARS = 256;
        int[] window = new int[MAX_CHARS];
        int[] dict = new int[MAX_CHARS];
        int NOT_EXISTED = -1;
        int NOT_FOUND = 0;
        for (int i = 0; i < MAX_CHARS; i++) {
            window[i] = NOT_EXISTED;
            dict[i] = NOT_EXISTED;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (dict[c] == NOT_EXISTED) {
                dict[c] = 1;
            } else {
                dict[c]++;
            }

            window[c] = NOT_FOUND;
        }

        int start = -1;
        int winSize = Integer.MAX_VALUE;
        int letterFound = 0; //letter：字母
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (dict[c] == NOT_EXISTED) {
                continue;
            }

            window[c]++;

            //如果一个字符所有都被找到了，就不累加letterFound
            if (window[c] <= dict[c]) {
                letterFound++;
            }

            if (letterFound >= t.length()) {

                char cl = s.charAt(left);
                while (window[cl] == NOT_EXISTED || window[cl] > dict[cl]) {
                    if (dict[cl] != NOT_EXISTED) {
                        window[cl]--;
                        if (window[cl] < dict[cl]) {
                            letterFound--;
                        }
                    }
                    cl = s.charAt(++left);
                }

                if (winSize > right - left + 1) {
                    start = left;
                    winSize = right - left + 1;
                }
            }


        }

        if (start >= 0 && winSize > 0) {
            win = s.substring(start, start + winSize);
        }
        return win;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}

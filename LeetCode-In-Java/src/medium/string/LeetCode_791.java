package medium.string;

public class LeetCode_791 {

    public String customSortString(String S, String T) {
        int[] map = new int[26]; //idx: letter, element: cnt

        for (char ch : T.toCharArray()) {
            int idx = ch - 'a';
            map[idx] = map[idx] + 1;
        }

        char[] res = new char[T.length()];
        int idx = 0;
        for (char ch : S.toCharArray()) {
            int tmp = ch - 'a';
            int cnt = map[tmp];
            while (cnt > 0) {
                res[idx] = ch;
                cnt--;
                idx++;
            }
            map[tmp] = 0;
        }

        for (int i = 0; i < map.length; i++) {
            int cnt = map[i];
            while (cnt > 0) {
                res[idx] = (char) (i + 'a');
                cnt--;
                idx++;
            }
        }

        String result = new String(res);
        return result;
    }

    public static void main(String[] args) {
        LeetCode_791 leetCode_791 = new LeetCode_791();
        String s = leetCode_791.customSortString("cbafg", "abcd");
    }
}

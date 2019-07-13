package medium.string;

public class LeetCode_791 {

    public String customSortString(String S, String T) {
        //idx: letter, element: cnt. T max len is 200，so can use byte arr. but need change negative
        byte[] map = new byte[26];

        for (char ch : T.toCharArray()) {
            int idx = ch - 'a';
            map[idx] = (byte) (map[idx] + 1);
        }

        char[] res = new char[T.length()];
        int idx = 0;
        for (char ch : S.toCharArray()) {
            int tmp = ch - 'a';

            //change negative
            int cnt = b2i(map[tmp]);
            while (cnt > 0) {
                res[idx] = ch;
                cnt--;
                idx++;
            }
            map[tmp] = 0;
        }

        for (int i = 0; i < map.length; i++) {
            int cnt = b2i(map[i]);
            while (cnt > 0) {
                res[idx] = (char) (i + 'a');
                cnt--;
                idx++;
            }
        }

        String result = new String(res);
        return result;
    }

    public int b2i(byte b) {
        int i = b;
        if (b < 0) {
            i = (b + 128) + 128;
        }
        return i;
    }

    
}

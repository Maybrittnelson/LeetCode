package medium.string;

public class LeetCode_767 {

    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        int[] cnts = new int[26];
        char[] chs = S.toCharArray();
        for (char c : chs) {
            int i = c - 'a';
            cnts[i]++;
        }

        int maxCnt = 0;
        int maxIdx = 0;
        for (int i = 0; i < cnts.length; i++) {
            int tmp;
            if ((tmp = cnts[i]) > maxCnt) {
                maxCnt = tmp;
                maxIdx = i;
            }
        }

        //maxCnt -1 <= len - maxCnt 才能成立，即
        int len = chs.length;
        if (maxCnt - 1 > len - maxCnt) {
            return "";
        }

        char[] resChs = new char[S.length()];
        int idx = 0;
        while (maxCnt > 0) {
            resChs[idx] = (char) (maxIdx + 'a');
            maxCnt--;
            idx += 2;
        }

        for (int i = 0; i < cnts.length; i++) {
            int cnt;
            if (maxIdx == i || (cnt = cnts[i]) == 0) {
                continue;
            }

            while (cnt > 0) {

                if (idx >= len) {
                    idx = 1;
                }
                resChs[idx] = (char) (i + 'a');
                cnt--;
                idx += 2;
            }
        }

        String res = new String(resChs);
        return res;
    }

}

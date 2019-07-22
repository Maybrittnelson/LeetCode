package medium.queue;

import java.util.Arrays;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/22
 */
public class LeetCode_621 {

    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char c : tasks) {
            cnt[c - 'A']++;
        }

        Arrays.sort(cnt);
        int i = 25;
        while (i >= 0 && cnt[i] == cnt[25]) {
            i--;
        }
        return Math.max(tasks.length, (cnt[25] - 1) * (n + 1) + 25 - i);
    }
}

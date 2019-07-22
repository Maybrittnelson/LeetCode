package medium.queue;

import java.util.*;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/22
 */
public class LeetCode_621 {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(map.values());

        int alltime = 0;
        int chunk = n + 1;
        while (!queue.isEmpty()) {
            int worktime = 0;
            int[] tmp = new int[chunk];
            for (int i = 0; i < chunk; i++) {
                if (!queue.isEmpty()) {
                    tmp[i] = queue.poll();
                    worktime++;
                }
            }
            for (int cnt : tmp) {
                if (--cnt > 0) {
                    queue.add(cnt);
                }
            }
            alltime += queue.isEmpty() ? worktime : chunk;
        }
        return alltime;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'A', 'A', 'A', 'B', 'B', 'C', 'D'};
        LeetCode_621 leetCode_621 = new LeetCode_621();
        leetCode_621.leastInterval(chars, 2);
    }

/*    public int leastInterval(char[] tasks, int n) {
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
    }*/
}

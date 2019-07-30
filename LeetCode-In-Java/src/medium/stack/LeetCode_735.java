package medium.stack;

import java.util.LinkedList;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/30
 */
public class LeetCode_735 {

    public int[] asteroridCollision(int[] asteroids) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i : asteroids) {
            if (i > 0) {
                res.add(i);
            } else {
                while (!res.isEmpty() && res.getLast() > 0 && res.getLast() < -i) {
                    res.pollLast();
                }
                if (!res.isEmpty() && res.getLast() == -i) {
                    res.pollLast();
                } else if (res.isEmpty() || res.getLast() < 0) {
                    res.add(i);
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}

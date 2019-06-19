package BreadthFirstSearch;

import java.util.LinkedList;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/5/20
 */
public class LeetCode_200 {


    public int islandNumber(char[][] is) {
        if (is == null || is.length == 0) {
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is[i].length; j++) {
                if (is[i][j] == '1') {
                    cnt = dfs(is, i, j) + cnt;
                }
            }
        }
        return cnt;
    }

    public int dfs(char[][] is, int i, int j) {
        if (i < 0 || i >= is.length || j < 0 || j >= is[i].length || is[i][j] == '0') {
            return 0;
        }

        is[i][j] = 0;
        dfs(is, i + 1, j);
        dfs(is, i - 1, j);
        dfs(is, i, j + 1);
        dfs(is, i, j - 1);
        return 1;
    }
}

package hard.backtracing;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 下图是，以(0, 0)为起点遍历的过程
 * https://github.com/Maybrittnelson/LeetCode/blob/master/LeetCode-In-Java/src/mp4/51.mp4
 */
public class LeetCode_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] broad = new char[n][n];
        for (int i = 0; i < broad.length; i++) {
            for (int j = 0; j < broad[i].length; j++) {
                broad[i][j] = '.';
            }
        }

        backtrack(broad, 0, res);
        return res;
    }

    private void backtrack(char[][] broad, int colIndex, List<List<String>> res) {
        if (colIndex == broad.length) {
            res.add(construct(broad));
        }

        for (int rowIndex = 0; rowIndex < broad.length; rowIndex++) {
            if (validate(broad, rowIndex, colIndex)) {
                broad[rowIndex][colIndex] = 'Q';
                backtrack(broad, colIndex + 1, res);//前一列找到位置，colIndex+1，继续定位下一列。
                broad[rowIndex][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] broad, int i, int colIndex) {
        for (int x = 0; x < broad.length; x++) {
            for (int y = 0; y < colIndex; y++) {
                /**
                 * x ==i 是水平方向
                 * x + colIndex = i +y  是斜左上角
                 * x + y = colIndex + i 是斜左下角
                 */
                if (broad[x][y] == 'Q' && (x == i || x + colIndex == i + y || x + y == i + colIndex)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] broad) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < broad.length; i++) {
            String s = new String(broad[i]);
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode_51 leetCode_51 = new LeetCode_51();
        List<List<String>> lists = leetCode_51.solveNQueens(4);
        System.out.println(lists);
    }
}

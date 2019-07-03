package medium.string;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_22 {
    //Parenthesis: 插曲
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        String s = "";
        generator(result, n, n, s);
        return result;
    }

    public void generator(LinkedList<String> result, int left, int right, String s) {
        if(left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if(left>0) {
            generator(result, left-1, right, s+"(");
        }
        if(right>0 && right>left) {
            generator(result, left, right-1, s+")");
        }
    }
}

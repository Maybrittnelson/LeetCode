package medium.stack;

import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/18
 */
public class LeetCode_71 {

    //"/a/b"
    public String simpleifyPath(String path) {

        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(s) && !"".equals(s)) {
                stack.push(s);
            }
        }

        String result = "";
        for (String s : stack) {
            result += "/" + s ;
        }
        return result.isEmpty() ? "/" : result;
    }

    public static void main(String[] args) {
        LeetCode_71 leetCode_71 = new LeetCode_71();
        leetCode_71.simpleifyPath("/a/b");
    }


}

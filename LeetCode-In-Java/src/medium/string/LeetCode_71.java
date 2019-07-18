package medium.string;

public class LeetCode_71 {

    //
    public String simplifyPath(String path) {

        String result = "";
        String[] elems = path.split("/");

        int ignor = 0;
        for (int i = elems.length - 1; i >= 0; i--) {

            if ("".equals(elems[i]) || ".".equals(elems[i])) {
                continue;
            }
            if ("..".equals(elems[i])) {
                ignor++;
                continue;
            }
            if (ignor > 0) {
                ignor--;
                continue;
            }

            if (result.length() == 0) {
                result = "/" + elems[i];
            } else {
                result = "/" + elems[i] + result;
            }
        }

        return result.length() > 0 ? result : "/";
    }

    public static void main(String[] args) {
        LeetCode_71 leetCode_71 = new LeetCode_71();
        String s = leetCode_71.simplifyPath("/a/./b/../../c/");
        System.out.println(s);
    }
}

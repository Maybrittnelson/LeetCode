package medium.string;

public class LeetCode_165 {

    public static int compareVersion(String version1, String version2) {

        String[] ss1 = version1.split("\\.");
        String[] ss2 = version2.split("\\.");
        int l1 = 0;
        int l2 = 0;
        for (; l1 < ss1.length && l2 < ss2.length; l1++, l2++) {
            if (Integer.parseInt(ss1[l1]) > Integer.parseInt(ss2[l2])) {
                return 1;
            } else if (Integer.parseInt(ss1[l1]) < Integer.parseInt(ss2[l2])) {
                return -1;
            }
        }

        for (; l1 < ss1.length; l1++) {
            if (Integer.parseInt(ss1[l1]) > 0) {
                return 1;
            }
        }
        for (; l2 < ss2.length; l2++) {
            if (Integer.parseInt(ss2[l2]) > 0) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = compareVersion("0.1", "1.1");

    }
}

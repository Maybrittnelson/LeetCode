package medium.string;

public class LeetCode_3 {

    public int lengthOfLongestSubstring(String s) {
        int max_chars = 256;
        int[] arr = new int[max_chars];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        int maxLen = 0;
        int lastRepeatPos = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c] != -1 && lastRepeatPos < arr[c]) {
                lastRepeatPos = arr[c];
            }
            if (i - lastRepeatPos > maxLen) {
                maxLen = i - lastRepeatPos;
            }
            arr[c] = i;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LeetCode_3 leetCode_3 = new LeetCode_3();
        System.out.println(leetCode_3.lengthOfLongestSubstring("abc"));
    }
}

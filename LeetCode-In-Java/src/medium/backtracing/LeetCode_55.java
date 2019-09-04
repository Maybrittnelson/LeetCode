package medium.backtracing;

public class LeetCode_55 {

    //dp
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len - 1, i;
        for (i = len - 2; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }

/*
    backtrack
    public boolean canJump_1(int[] nums) {
        return backtrack(nums, 0);
    }

    public boolean backtrack(int[] nums, int idx) {

        if (idx >= nums.length - 1) {
            return true;
        }

        if (nums[idx] == 0) {
            return false;
        }

        for (int i = 1; i <= nums[idx]; i++) {
            if (backtrack(nums, idx + 1)) {
                return true;
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
        LeetCode_55 leetCode_55 = new LeetCode_55();
        boolean b = leetCode_55.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(b);
    }
}

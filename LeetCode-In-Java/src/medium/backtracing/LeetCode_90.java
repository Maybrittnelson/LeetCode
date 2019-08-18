package medium.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start) {
        result.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tmpList.add(nums[i]);
            backtrack(result, tmpList, nums, i+1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_90 leetCode_90 = new LeetCode_90();
        List<List<Integer>> lists = leetCode_90.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }
}

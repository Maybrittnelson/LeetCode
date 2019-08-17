package medium.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_46 {

    //permute：重新排序
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            result.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmpList.contains(nums[i])) continue;
                tmpList.add(nums[i]);
                backtrack(result, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_46 leetCode_46 = new LeetCode_46();
        List<List<Integer>> permute = leetCode_46.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}

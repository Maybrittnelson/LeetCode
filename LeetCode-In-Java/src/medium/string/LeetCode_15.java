package medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        int len = nums.length;

        for (int fi = 0; fi < len - 2; fi++) {
            //首位元素之前没有出现过，即可保证，三元素唯一
            if (fi > 0 && nums[fi] == nums[fi - 1]) {
                continue;
            }

            int first = nums[fi];
            int si = fi + 1;//second index
            int ti = len - 1;//thrid index
            while (si < ti) {
                int second = nums[si];
                int thrid = nums[ti];
                if (first + second + thrid == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(thrid);

                    result.add(list);
                    while (si < len - 1 && nums[si] == nums[si + 1]) {
                        si++;
                    }
                    si++;
                    while (0 < ti && nums[ti] == nums[ti - 1]) {
                        ti--;
                    }
                    ti--;
                } else if (first + second + thrid < 0) {
                    while (si < len - 1 && nums[si] == nums[si + 1]) {
                        si++;
                    }
                    si++;
                } else {
                    while (0 < ti && nums[ti] == nums[ti - 1]) {
                        ti--;
                    }
                    ti--;
                }
            }
        }

        return result;
    }

}

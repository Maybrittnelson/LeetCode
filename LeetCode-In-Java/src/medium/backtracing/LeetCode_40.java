package medium.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tmpList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tmpList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i] == candidates[i - 1]) continue;
                tmpList.add(candidates[i]);
                backtrack(result, tmpList, candidates, remain - candidates[i], i + 1);//use next position
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_40 leetCode_40 = new LeetCode_40();
        List<List<Integer>> lists = leetCode_40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(lists);
    }

}

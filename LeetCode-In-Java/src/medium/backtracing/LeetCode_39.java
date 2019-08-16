package medium.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_39 {

    //combination：组合，candidates：候选人
    //keyword：candidates 无重复元素
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, candidates, new ArrayList<>(), target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, int[] candidates, List<Integer> tmpList, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tmpList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmpList.add(candidates[i]);
                System.out.println("我添加了：" + candidates[i]);
                backtrack(result, candidates, tmpList, remain - candidates[i], i);
                System.out.println("当前集合：" + tmpList.toString() + "，我删除了最后一个元素为：" + tmpList.get(tmpList.size() - 1));
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        LeetCode_39 leetCode_39 = new LeetCode_39();
        List<List<Integer>> lists = leetCode_39.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }
}

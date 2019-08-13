package medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LeetCode_380 {

    class RandomizedSet {
        Random random = new Random();
        ArrayList<Integer> arr;
        HashMap<Integer, Integer> map;

        public RandomizedSet() {
            arr = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            Integer cur = map.get(val);
            if (cur != null) {
                return false;
            }

            arr.add(val);
            map.put(val, arr.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            Integer cur = map.get(val);
            if (cur == null) {
                return false;
            }

            //重新设置cur位置上的值
            if (cur < arr.size() - 1) {
                Integer last = arr.get(arr.size() - 1);
                arr.set(cur, last);
                map.put(last, cur);
            }
            arr.remove(arr.size()-1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return arr.get(random.nextInt(arr.size()));
        }
    }

}

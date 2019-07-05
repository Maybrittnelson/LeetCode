package medium.string;

import java.util.*;

public class LeetCode_49 {

    public List<List<String>> groupAngrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = null;
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            if (word != null && word.length() > 1) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                word = new String(chars);
            }

            if (!map.containsKey(word)) {
                list = new LinkedList<>();
                map.put(word, list);
            } else {
                list = map.get(word);
            }
            list.add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        Collection<List<String>> values = map.values();
        for (List<String> value : values) {
            result.add(value);
        }

        return result;
    }

}

package medium.string;

import java.util.*;

public class LeetCode_609 {

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new LinkedList<>();
        if (paths == null || paths.length < 1) {
            return result;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String dpath : paths) {
            String[] ss = dpath.split(" ");

            for (int i = 0; i < ss.length; i++) {
                if (i == 0) {
                    dpath = ss[0];
                } else {
                    String filename = ss[i].substring(0, ss[i].indexOf("("));
                    String content = ss[i].substring(ss[i].indexOf("(") + 1, ss[i].indexOf(")"));
                    List<String> list = null;
                    if (!map.containsKey(content)) {
                        list = new ArrayList<>();
                        map.put(content, list);
                    } else {
                        list = map.get(content);
                    }
                    list.add(dpath + "/" + filename);
                }
            }
        }

        Collection<List<String>> values = map.values();
        for (List list : values) {
            if (list.size() > 1) {
                result.add(list);
            }
        }

        return result;
    }
}

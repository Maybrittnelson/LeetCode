package medium.heap;

import medium.string.LeetCode_76;

import java.util.*;

//Given a non-empty list of words, return the k most frequent elements
//Your answer should be sorted by frequency from highest to lowest. if two words have the same frequency,
// then the word with lower alphabetical order comes first.
public class LeetCode_692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        //维护小顶堆
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode_692 leetCode_692 = new LeetCode_692();
        leetCode_692.topKFrequent(new String[]{"i", "k", "i", "love", "love"}, 2);
    }
}

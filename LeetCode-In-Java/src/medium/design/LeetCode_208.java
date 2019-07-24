package medium.design;

import java.util.HashMap;

/**
 * 128,264,416 + 3,147,624
 * 131,412,040 byte= 125 M
 */
public class LeetCode_208 {

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null || word.length() < 1) {
                return;
            }

            TrieNode node = root;
            Character curChar;
            for (int i = 0; i < word.length(); i++) {
                curChar = word.charAt(i);
                if (!node.children.containsKey(curChar)) {
                    node.children.put(curChar, new TrieNode());
                }
                node = node.children.get(curChar);
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            return retrieve(word, true);
        }

        public boolean startsWith(String word) {
            return retrieve(word, false);
        }

        private boolean retrieve(String word, boolean isWord) {
            if (word == null || word.length() < 1) {
                return false;
            }

            TrieNode node = root;
            Character curChar;
            for (int i = 0; i < word.length(); i++) {
                curChar = word.charAt(i);
                if (!node.children.containsKey(curChar)) {
                    return false;
                }
                node = node.children.get(curChar);
            }
            return isWord ? node.isWord : true;
        }
    }

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        for (int i = 0; i < 50000; i++) {
            trie.insert(Math.random() + i + "");
        }
        System.out.println();
    }
}

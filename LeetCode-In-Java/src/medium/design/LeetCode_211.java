package medium.design;

public class LeetCode_211 {

    static final int MAX_CHARS = 26;

    static class WordDictionary {

        private TrieTree tree;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            tree = new TrieTree();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            tree.put(word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return tree.search(word);
        }
    }

    static class TrieTree {
        TrieNode root;

        TrieTree() {
            root = new TrieNode();
        }

        void put(String s) {
            TrieNode node = root;
            for (int i = 0; i < s.length(); i++) {
                TrieNode item = node.getByChar(s.charAt(i));
                if (item == null) {
                    item = node.putAndGet(s.charAt(i));
                }
                node = item;
            }
            node.isWord = true;
        }

        boolean search(String s) {
            return get(s, root, 0);
        }

        boolean get(String s, TrieNode root, int idx) {
            TrieNode node = root;
            for (int i = idx; i < s.length(); i++) {
                if (s.charAt(i) != '.') {
                    node = node.getByChar(s.charAt(i));
                    if (node == null) {
                        return false;
                    }
                } else {
                    for (int j = 0; j < MAX_CHARS; j++) {
                        TrieNode p = node.getByIndex(j);
                        if (p == null) {
                            continue;
                        }

                        if (i < s.length() - 1) {
                            if (get(s, p, i + 1)) {
                                return true;
                            }
                            continue;
                        }

                        if (p.isWord) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return node.isWord;
        }
    }

    static class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[MAX_CHARS];

        TrieNode getByChar(Character character) {
            int i = (character - 'a') % MAX_CHARS;
            return children[i];
        }

        TrieNode putAndGet(Character character) {
            int i = (character - 'a') % MAX_CHARS;
            children[i] = new TrieNode();
            return children[i];
        }

        TrieNode getByIndex(int idx) {
            int i = idx % MAX_CHARS;
            return children[i];
        }


    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        System.out.println(wd.search("a."));
        System.out.println(wd.search(".a"));

        wd.addWord("bad");
        System.out.println(wd.search("bad"));
        System.out.println(wd.search("b.."));
    }
}
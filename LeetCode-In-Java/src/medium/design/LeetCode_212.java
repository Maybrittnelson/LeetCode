package medium.design;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_212 {

    static final int MAX_CHARS = 26;

    public static List<String> findWords(char[][] board, String[] words) {
        TrieTree trieTree = new TrieTree();
        for (int i = 0; i < words.length; i++) {
            trieTree.addWord(words[i]);
        }

        List<String> result = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                findWords(board, trieTree.root, i, j, result);
            }
        }
        return result;
    }

    public static void findWords(char[][] board, TrieNode root, int row, int column, List<String> result) {
        if (row < 0 || column < 0 ||
                row >= board.length || column >= board[row].length ||
                board[row][column] == '\0') {
            return;
        }

        char ch = board[row][column];
        root = root.getByChar(ch);

        if (root == null) {
            return;
        }

        if (root.isWord) {
            result.add(root.word);
            root.isWord = false;
        }

        board[row][column] = '\0';

        findWords(board, root, row, column - 1, result);
        findWords(board, root, row, column + 1, result);
        findWords(board, root, row - 1, column, result);
        findWords(board, root, row + 1, column, result);

        board[row][column] = ch;
    }

    static class TrieTree {
        TrieNode root;

        public TrieTree() {
            root = new TrieNode("");
        }

        void addWord(String s) {
            TrieNode node = root;
            String t = "";
            Character curChar = null;
            for (int i = 0; i < s.length(); i++) {
                curChar = s.charAt(i);
                TrieNode item = node.getByChar(curChar);
                t += curChar;
                if (item == null) {
                    item = node.putAndGet(curChar, t);
                }
                node = item;
            }
            node.isWord = true;
        }


    }

    static class TrieNode {
        String word;
        boolean isWord;
        TrieNode[] children;

        public TrieNode(String word) {
            this.word = word;
            children = new TrieNode[MAX_CHARS];
        }

        public TrieNode putAndGet(Character character, String word) {
            int i = (character - 'a') % MAX_CHARS;
            children[i] = new TrieNode(word);
            return children[i];
        }

        public TrieNode getByChar(Character character) {
            int i = (character - 'a') % MAX_CHARS;
            return children[i];
        }

        public TrieNode getByIdx(int i) {
            return children[i % MAX_CHARS];
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> words1 = findWords(board, words);
        System.out.println(words1);

    }
}

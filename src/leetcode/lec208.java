package leetcode;

public class lec208 {
}

class Trie {
    int[][] son;
    boolean[][] hasWrod;
    int idx = 0;
    public Trie() {
        son = new int[100010][26];
        hasWrod = new boolean[100010][26];
    }

    public void insert(String word) {
        int p = 0;
        int len = word.length();
        for (int i = 0; i < len; i ++ ) {
            int u = word.charAt(i) - 'a';
            if (son[p][u] == 0) son[p][u] = ++ idx;
            if (i == len - 1) hasWrod[p][u] = true;
            p = son[p][u];
        }
    }

    public boolean search(String word) {
        int p = 0;
        int len = word.length();
        for (int i = 0; i < len - 1; i ++ ) {
            int u = word.charAt(i) - 'a';
            if (son[p][u] == 0) return false;
            p = son[p][u];
        }
        return hasWrod[p][word.charAt(len - 1) - 'a'];
    }

    public boolean startsWith(String prefix) {
        int p = 0;
        int len = prefix.length();
        for (int i = 0; i < len; i ++ ) {
            int u = prefix.charAt(i) - 'a';
            if (son[p][u] == 0) return false;
            p = son[p][u];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
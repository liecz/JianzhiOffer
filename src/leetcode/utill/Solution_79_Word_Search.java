package leetcode.utill;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * <p>
 * https://leetcode.com/problems/word-search/description/
 * Created by liec on 2017-09-06.
 */
public class Solution_79_Word_Search {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] chars, int x, int y, int i) {
        if (i == chars.length) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length) return false;
        if (chars[i] != board[x][y]) return false;
        board[x][y] ^= 256;
        boolean ans = exist(board, chars, x - 1, y, i + 1) ||
                exist(board, chars, x, y + 1, i + 1) ||
                exist(board, chars, x + 1, y, i + 1) ||
                exist(board, chars, x, y - 1, i + 1);
        board[x][y] ^= 256;
        return ans;
    }

}

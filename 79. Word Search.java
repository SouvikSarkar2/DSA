//Beats 100%
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m * n < word.length())
            return false;
        char[] wrd = word.toCharArray();
        int[] boardf = new int[128];

        // Count the frequency of each character on the board
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ++boardf[board[i][j]];
            }
        }

        // Check if the characters in the word are available on the board
        for (char ch : wrd) {
            if (--boardf[ch] < 0) {
                return false;
            }
        }

        // Reverse the word if the first character has a higher frequency on the board
        if (boardf[wrd[0]] > boardf[wrd[wrd.length - 1]])
            reverse(wrd);

        // Search for the word on the board starting from each cell
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (wrd[0] == board[i][j] && found(board, i, j, wrd, new boolean[m][n], 0))
                    return true;
            }
        }

        return false;
    }

    // Reverse the characters in the word
    private void reverse(char[] word) {
        int n = word.length;
        for (int i = 0; i < n / 2; ++i) {
            char temp = word[i];
            word[i] = word[n - i - 1];
            word[n - i - 1] = temp;
        }
    }

    // Define the directions: Up, Left, Down, Right
    private static final int[] dirs = { 0, -1, 0, 1, 0 };

    // Recursively search for the word on the board
    private boolean found(char[][] board, int row, int col, char[] word, boolean[][] visited, int index) {
        if (index == word.length)
            return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length
                || board[row][col] != word[index] || visited[row][col])
            return false;
        visited[row][col] = true;
        for (int i = 0; i < 4; ++i) {
            if (found(board, row + dirs[i], col + dirs[i + 1], word, visited, index + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}

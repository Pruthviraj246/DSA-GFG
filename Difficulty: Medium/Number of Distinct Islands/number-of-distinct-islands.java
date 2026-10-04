class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int countDistinctIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!vis[i][j] && grid[i][j] == 'L') {

                    ArrayList<String> vec = new ArrayList<>();

                    dfs(i, j, grid, vis, vec, i, j);

                    set.add(vec);
                }
            }
        }

        return set.size();
    }

    static void dfs(int row, int col, char[][] grid,
                    boolean[][] vis,
                    ArrayList<String> vec,
                    int row0, int col0) {

        vis[row][col] = true;

      
        vec.add(toString(row - row0, col - col0));

        int n = grid.length;
        int m = grid[0].length;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                grid[nrow][ncol] == 'L' &&
                !vis[nrow][ncol]) {

                dfs(nrow, ncol, grid, vis,
                    vec, row0, col0);
            }
        }
    }

    static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
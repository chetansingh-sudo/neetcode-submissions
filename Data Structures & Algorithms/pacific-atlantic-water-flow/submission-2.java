class Solution {

    boolean pacific, atlantic;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public void dfs(int[][] h, boolean[][] vis, int r, int c) {

        if (pacific && atlantic)
            return;

        vis[r][c] = true;

        int n = h.length;
        int m = h[0].length;

        if (r == 0 || c == 0)
            pacific = true;

        if (r == n - 1 || c == m - 1)
            atlantic = true;

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                !vis[nr][nc] &&
                h[nr][nc] <= h[r][c]) {

                dfs(h, vis, nr, nc);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                pacific = false;
                atlantic = false;

                boolean[][] vis = new boolean[n][m];

                dfs(heights, vis, i, j);

                if (pacific && atlantic)
                    ans.add(Arrays.asList(i, j));
            }
        }

        return ans;
    }
}
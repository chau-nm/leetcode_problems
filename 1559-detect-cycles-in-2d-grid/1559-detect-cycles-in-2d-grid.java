class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j]){
                    if(dfs(i, j, -1, -1, grid, vis)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int px, int py, char[][] grid, boolean[][] vis){
        vis[x][y] = true;

        int n = grid.length;
        int m = grid[0].length;

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(grid[nx][ny] != grid[x][y]) continue;

            if(vis[nx][ny] && !(nx == px && ny == py)) return true;

            if(!vis[nx][ny]){
                if(dfs(nx, ny, x, y, grid, vis)) return true;
            }
        }
        return false;
    }
}
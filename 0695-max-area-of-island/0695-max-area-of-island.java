class Solution {
    
    private static int[] mx = {0, 0, 1, -1};
    private static int[] my = {1, -1, 0, 0};
    private static boolean[][] check;
    private static int lx, ly;

    private int dfs(int x, int y, int cnt, int[][] grid){
        
        for(int i=0; i<4; i++){
            int curX = x + mx[i];
            int curY = y + my[i];
            if(curX >=0 && curX < lx && curY >= 0 && curY < ly){
                if(grid[curY][curX] == 1 && !check[curY][curX]){
                    check[curY][curX] = true;
                    cnt = dfs(curX, curY, cnt, grid);
                }
            }
        }

        return cnt + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {

        ly = grid.length;
        lx = grid[0].length;
        
        check = new boolean[ly][lx];
        int ans = 0;

        for(int i=0; i<ly; i++){
            for(int j=0; j<lx; j++){
                if(grid[i][j] == 1 &&!check[i][j]){
                    check[i][j] = true;
                    int size = dfs(j,i, 0, grid);

                    ans = Math.max(size, ans);
                }
            }
        }

        return ans;
    }
}
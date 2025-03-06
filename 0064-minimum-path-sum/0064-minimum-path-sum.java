class Solution {
    public int minPathSum(int[][] grid) {
        //해당 부분에 도착했을 때의 최소 비용을 저장
        // 문제 잘읽기... 항상 우측, 아래측으로만 갈 수 있다는 점을 제대로 파악하지 못해서 시간이 너무 많이 걸림

        //좌측열 초기화 
        for(int i=1; i<grid.length;i++){
            grid[i][0] += grid[i-1][0];
        }

        //최상단열 초기화 
        for(int i=1; i<grid[0].length;i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i=1;i<grid.length;i++){
            for(int j=1; j<grid[0].length;j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

}
class Solution {
    
    public static int MOD = 1_000_000_007;
    public static int ans = 0;
    
    public static int maxX, maxY;
    
    
    public int solution(int m, int n, int[][] puddles) {
        
        maxX = m;
        maxY = n;
        
        int[][] map = new int[n][m];
        
        for(int[] puddle : puddles ){
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        map[0][0] = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                if(map[i][j] == -1) continue;
                
                if(j+1<m && map[i][j+1] != -1){
                    map[i][j+1] += map[i][j];
                    map[i][j+1] %= MOD;
                }
                if(i+1<n && map[i+1][j] != -1){
                    map[i+1][j] += map[i][j];
                    map[i+1][j] %= MOD;
                }
            }
        }
        
    
        return map[n-1][m-1];
    }

}
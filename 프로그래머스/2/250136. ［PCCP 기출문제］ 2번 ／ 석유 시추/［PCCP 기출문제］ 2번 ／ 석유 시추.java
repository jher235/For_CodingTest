import java.util.*;
class Solution {
    
    static int[] mx = {0,0, 1, -1};
    static int[] my = {1, -1,0,0};
    
    static int n, m;
    
    static boolean[][] visited;
    
    static boolean[] visitedGround;
    static int[] ground;
            
    //그라운드를 인트 배열로 놓고 dfs로 탐색하면서 각 부분에 추가? -> 석유 총량을 어떻게 더해줄까? -> 리스트를 만들고 탐색이 끝나면 한번에 더해주기? 
    public int solution(int[][] land) {
        int answer = 0;
        m = land.length;
        n = land[0].length;
        
        // x축 마다 석유의 양
        ground = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for(int i=0; i< land.length; i++){
            for(int j=0;j<land[0].length; j++){
                if(land[i][j]==1 && visited[i][j]==false){
                    visitedGround = new boolean[land[0].length];
                    
                    visited[i][j]=true;
                    visitedGround[j] = true;
                    int s = dfs(j, i, land);
                    
                    for(int k=0; k<visitedGround.length; k++ ){
                        if(visitedGround[k]){ //이번 석유에 x축이 포함되면 증가
                            ground[k] += s;
                        }
                    }
                }
                
            }
        }
        
        for(int i=0; i< ground.length; i++){
            answer = Math.max(answer, ground[i]);
        }

        return answer;
    }
    
    public static int dfs(int x, int y, int[][] land){
        
        int value = 1;
        for(int i=0;i<4;i++){
            int nextX = x + mx[i];
            int nextY = y + my[i];
            
            if(nextX>=0 && nextX < n 
               && nextY>=0 && nextY < m 
               && visited[nextY][nextX] == false
               && land[nextY][nextX] == 1){
                visited[nextY][nextX] = true; 
                visitedGround[nextX] = true; //이번 석유가 x축에 포함됨을 체크
                value += dfs(nextX, nextY, land);
            }
        }
        
        return value;
    }
}
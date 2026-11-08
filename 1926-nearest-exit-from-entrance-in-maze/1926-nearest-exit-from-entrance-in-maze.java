import java.util.*;

class Solution {

    int[] mx = new int[]{0, 0, -1, 1};
    int[] my = new int[]{-1, 1, 0, 0};

    boolean[][] visit ;

    int n, m;

    public int nearestExit(char[][] maze, int[] entrance) {

        // y, x
        n = maze.length;
        m = maze[0].length;

        visit = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();



        visit[entrance[0]][entrance[1]] = true;
        for(int i=0; i<4; i++){
            int nx = entrance[1] + mx[i];
            int ny = entrance[0] + my[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                if(maze[ny][nx] != '+'){
                    queue.add(new int[]{ny, nx, 1});
                    visit[ny][nx] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            for(int i=0; i<4; i++){
                int nx = curX + mx[i];
                int ny = curY + my[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(maze[ny][nx] != '+' && !visit[ny][nx] ){
                        queue.add(new int[]{ny, nx, cur[2] + 1});
                        visit[ny][nx] = true;
                    }
                }else{
                    return cur[2];
                }
            }

        }


        return -1;



        
        
    }
}
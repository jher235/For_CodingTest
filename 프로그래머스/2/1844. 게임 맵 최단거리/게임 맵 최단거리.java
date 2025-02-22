import java.util.*;

class Solution {
    
    int[] mx = {0, 0, 1, -1};
    int[] my = {1, -1, 0, 0};
    int[][] map;
    boolean complete = false; 
    // int ans = Integer.MAX_VALUE;
    int ans;
    boolean[][] visited;
    
    int m, n;
    
    public int solution(int[][] maps) {
       
        m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];
        // visited[0][0] = true;
        map = maps;
        ans = 0;
        bfs();
        
        if (ans!=0){
            return ans;
        }
        return -1;
        
//         dfs(0,0, 1);
        
//         if(complete){
//             return ans;
//         }
        
//         return -1;
      
    }
    
    private void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.y==m-1 && node.x==n-1){
                 ans=node.cost;
                 return;
            }
          
            
             for(int i=0;i<4;i++){
                int nx = node.x + mx[i];
                int ny = node.y + my[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m 
                   && map[ny][nx]==1 && visited[ny][nx]==false){
                    visited[ny][nx] = true;
                    queue.add(new Node(nx, ny, node.cost+1));
                }
             }
            
            
        }

        
    }
    
    private static class Node{
        int x;
        int y;
        int cost;
        
        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
//     private void dfs(int cy, int cx, int depth){
        
//         if(cy==m-1 && cx==n-1){
//             if(depth<ans){
//                 ans = depth;
//             }
//             complete = true;
//             return;
//         }
        
        
//         for(int i=0;i<4;i++){
//             int nx = cx + mx[i];
//             int ny = cy + my[i];
//             if(nx>=0 && nx<n && ny>=0 && ny<m 
//                && map[ny][nx]==1 && visited[ny][nx]==false){
//                 visited[cy][cx] = true;
//                 visited[ny][nx]=true;
//                 dfs(ny, nx, depth+1);
//                 visited[ny][nx]=false;
//                 visited[cy][cx] = false;
//             }
//         }
        
//     }
    
    
}
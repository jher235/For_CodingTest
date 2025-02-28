import java.util.*;

class Solution {
    
    static boolean[][] visited;
    
    static int[] mx = {0,0,1,-1};
    static int[] my = {1,-1,0,0};
    
    
    private static class Point{
        int x;
        int y;
        int moved;
        
        public Point(int x, int y, int moved){
            this.x = x;
            this.y = y;
            this.moved = moved;
        }
        
    }    
    
    //rectangle의 좌표의 x,y축 중 하나 이상 겹치고 
    //모든 rectangle 좌표 내부에 있지 않아야함.
    // 2배 크기를 사용하여 모서리 -> 변 이동이나 변 -> 모서리 이동으로 잘못가는걸 방지
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // visited = new boolean[51][51];
        visited = new boolean[102][102];
        boolean[][] map = new boolean[102][102];
        
        for(int[] rect: rectangle){
            for(int i=rect[1] * 2; i<=rect[3] * 2;i++){
                for(int j=rect[0] * 2;j<=rect[2] * 2;j++){
                    map[i][j] = true;
                }
            }
        }
        
        itemX = itemX * 2;  
        itemY = itemY * 2; 
        
        Queue<Point> queue = new LinkedList<>();
        
        // visited[characterY][characterX] = true;
        map[characterY * 2][characterX * 2] = false;
        queue.add(new Point(characterX * 2, characterY * 2, 0));
        
        while(!queue.isEmpty()){
            
            Point point = queue.poll();

            for(int i=0; i<4; i++){
                
                int nextX = point.x + mx[i];
                int nextY = point.y + my[i];
                
                if(nextX == itemX  && nextY == itemY ){
                    return (point.moved + 1) /2;
                }
                
                if(map[nextY][nextX] == true 
                   && !isInner(rectangle, nextX, nextY)){
                    map[nextY][nextX] = false;
                    queue.add(new Point(nextX, nextY, point.moved + 1));
                }        
                
            }
        }
        
        return 0;
    }
    
    public static boolean isInner(int[][] rectangle, int nextX, int nextY){
        for(int[] rect : rectangle){        
            if(nextX > rect[0] * 2 && nextX < rect[2] * 2 &&
               nextY > rect[1] * 2 && nextY < rect[3] * 2){
                return true;
            }
        }
        return false;
    }
}
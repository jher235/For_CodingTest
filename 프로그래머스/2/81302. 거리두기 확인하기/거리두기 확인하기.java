import java.util.*;
class Solution {
    
    static int[] mx = {0,0,1,-1};
    static int[] my = {1, -1, 0,0};
    
    static boolean[][] visited;
    
    //기초적인 dfs
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        Arrays.fill(answer, 1);
        
        for(int caseNum = 0; caseNum<places.length; caseNum++){ 
            String[] place = places[caseNum];
   
            char[][] plc = new char[place.length][place[0].length()];
            visited = new boolean[place.length][place[0].length()];
            
            for(int i=0; i<place.length;i++){
                for(int j=0;j<place[i].length();j++){
                    plc[i][j] = place[i].charAt(j);
                }
            }
            
            for(int i=0; i<place.length;i++){
                for(int j=0;j<place[i].length();j++){
                    if(plc[i][j] == 'P' && answer[caseNum] == 1){
                        System.out.println("---");
                        visited[i][j] = true;
                        if(!isSafe(plc, j, i, 
                                   place[i].length(), place.length,0)){
                            
                            answer[caseNum] = 0;
                        }
                    }
                }
            }
            
        }
         
        return answer;
    }
    
    
    private static boolean isSafe(char[][] place, int x, int y, 
                                  int maxX, int maxY, int depth){
        
        if(depth>2){
            return true;
        }
        // System.out.println(x +", "+y);
        
        for(int i=0;i<4;i++){
            int nextX = x + mx[i];
            int nextY = y + my[i];
            
            if(nextX >= 0 && nextX<maxX 
               && nextY >=0 && nextY <maxY
               && place[nextY][nextX] != 'X' 
               && visited[nextY][nextX] == false
               && depth+1 < 3){
                visited[nextY][nextX] = true;
                if(place[nextY][nextX] == 'P'){
                    return false;
                }else if(place[nextY][nextX] == 'O'){
                    if(!isSafe(place, nextX, nextY, maxX, maxY, depth+1)){
                       return false; 
                    }
                }         
            }

        }
        return true;
    }
}
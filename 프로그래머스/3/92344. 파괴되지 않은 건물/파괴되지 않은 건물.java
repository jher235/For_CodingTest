class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int N = board.length;
        int M = board[0].length;

        int[][] diff = new int[N + 1][M + 1];

        for (int i = 0; i < skill.length; i++) {
            int type   = skill[i][0];
            int r1     = skill[i][1];
            int c1     = skill[i][2];
            int r2     = skill[i][3];
            int c2     = skill[i][4];
            int degree = skill[i][5];
        
            int d = 0;
            if(type == 1){
                d -= degree;
            }else{
                d += degree;
            }
            
            diff[r1][c1] += d;
            diff[r1][c2 + 1] -= d;
            diff[r2 + 1][c1] -= d;
            diff[r2 + 1][ c2 + 1] += d;
            
        }
        
        // StringBuilder sb = new StringBuilder();

        for(int j=0; j<M; j++){
            for(int i=1; i<N; i++){
                diff[i][j] += diff[i-1][j];
            }
        }
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
               
                if(j != 0){
                    diff[i][j] += diff[i][j-1];
                }
                
                // sb.append(diff[i][j] + "\t");
                
                if(board[i][j] + diff[i][j] > 0)  {
                    answer++;
                }  
            }
            // sb.append("\n");
        }
        
        // System.out.println(sb.toString());

        return answer;
    }
}
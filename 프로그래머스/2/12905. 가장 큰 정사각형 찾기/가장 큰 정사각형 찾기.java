class Solution
{
    public int solution(int [][]board)
    {
        int ans = 0;
        for(int i=0;i<board.length;i++){
            for(int j=1;j<board[0].length;j++){
                if(board[i][j]!=0){
                    board[i][j] += board[i][j-1];
                }
            }
        }
        
        for(int j=0;j<board[0].length;j++){
            int c = 0;
            int max = 0;
            for(int i=0;i<board.length;i++){
                if(board[i][j] != 0 && c < board[i][j]){
                    if(max==0) max = board[i][j];
                    c++;
                    max = Math.min(max, board[i][j]);
                }else{
                    ans = Math.max(ans, Math.min(max, c));
                    c = 0;
                    max = 0;
                }
            }
            ans = Math.max(ans, Math.min(max, c));
        }
 
        return ans * ans;
    }

}
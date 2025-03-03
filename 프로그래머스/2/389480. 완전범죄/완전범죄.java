import java.util.*;

class Solution {
    static int MAX = 12345678;
    
    // dp를 사용하려면 a에 대한 흔적과 b에 대한 흔적을 고려해야 함.
    public int solution(int[][] info, int n, int m) {
        
        //물건 순서, b의 누적 흔적 수. 저장되는 값은 a의 흔적 개수
        int[][] dp = new int[info.length+1][m+1];
        
        
        
        for(int[] arr : dp){
            Arrays.fill(arr, MAX);
        }
        dp[0][0] = 0;
        
        for(int i=1;i<=info.length;i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            for(int j=0;j<m;j++){
                // a로 받은 경우
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                
                //b로 받은 경우
                if(j+b < m){
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }             
            }
        }
        

        int answer = Integer.MAX_VALUE; 
        
        for(int i=0; i<dp.length;i++){
            for(int j=0; j<dp[0].length;j++){
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }
        
        
        for(int i=0; i<dp[0].length;i++){
            if( dp[dp.length-1][i] < n){
                answer = Math.min(answer, dp[dp.length-1][i]);
            }
            
        }
        if(answer >= MAX ) return -1;
        return answer;
    }
}

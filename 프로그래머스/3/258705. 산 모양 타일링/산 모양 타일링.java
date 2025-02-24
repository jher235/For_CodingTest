class Solution {
    public static int MOD = 10_007;
    //삼각 시 전부 1 / 2,1,1, / 1,2,1,
    //마름모 꼴 시 1,1,1, / 2, 1, / 1,2
    // [0]은 이전 마름모꼴에 포함된 경우 
    public int solution(int n, int[] tops) {
        
        int[][] dp = new int[n][2];
        
        dp[0][0]=1;
        dp[0][1]=2;
        if(tops[0]==1){
            dp[0][1]=3;
        }
        
        for(int i=1;i<n;i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][0] %= MOD;
            if(tops[i]==1){
                dp[i][1] = dp[i-1][0] * 2 + dp[i-1][1] * 3;
            }else{
                dp[i][1] = dp[i-1][0] + dp[i-1][1] * 2;
            }
            dp[i][1] %= MOD;
        }
        int answer = dp[n-1][0] + dp[n-1][1];
        answer %= MOD;
        return answer;
    }
}
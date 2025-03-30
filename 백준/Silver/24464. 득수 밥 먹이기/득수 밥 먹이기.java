
import java.io.*;


public class Main {
    private static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 현재 날짜 + 이전에 간 식당 번호. 0은 굶은 경우
        int[][] dp = new int[n+1][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;

        for (int i=1; i<n; ++i){
            dp[i][0] = ((dp[i-1][1] + dp[i-1][2])% MOD + (dp[i-1][3] + dp[i-1][4])% MOD) % MOD;
            dp[i][1] = ((dp[i-1][0] + dp[i-1][3]) % MOD + dp[i-1][4]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][4]) % MOD;
            dp[i][3] = (dp[i-1][0] + dp[i-1][1]) % MOD;
            dp[i][4] = ((dp[i-1][0] + dp[i-1][1]) % MOD + dp[i-1][2]) % MOD;
        }

        int ans = 0;
        for (int i=0;i<=4;i++){
            ans += dp[n-1][i];
            ans %= MOD;
        }
        System.out.println(ans );
    }

}
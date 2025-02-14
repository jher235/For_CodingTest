import java.io.*;
import java.util.*;


public class Main {
    public static int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dp = new int[K+1][N+1]; // 숫자의 순서, 현재까지의 합

        // 첫 번째 숫자 세팅. 경우의 수는 전부 1
        for (int i =0;i<=N;i++){
            dp[1][i]=1;
        }

        // 두 번째 숫자부터 K번째 숫자까지 세팅.
        for (int i=2;i<=K;i++){
            for (int j=0; j<=N;j++){
                if(j>0){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                dp[i][j] %= mod;
            }
        }

        System.out.println(dp[K][N]);

    }

}
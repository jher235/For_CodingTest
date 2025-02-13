import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int mod = 1_000_000_007;

        int[] dp = new int[N+1];
        dp[0] = 1;

        for (int i=1; i<=N;i++){
            dp[i] = dp[i-1];
            if(i>=M){
                dp[i] += dp[i-M];
                dp[i] %= mod;
            }
        }

        System.out.println(dp[N]);

    }

}
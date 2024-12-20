import java.io.*;
import java.util.*;


public class Main {

    static int[][] triangle;

    static int[][] dp;
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int count = stringTokenizer.countTokens();
            for (int j = 0; j < count; j++) {
                triangle[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        for (int i = 0; i < n - 1; i++) {
            dp[i + 1][0] = triangle[i + 1][0] + dp[i][0];
            dp[i + 1][i + 1] = triangle[i + 1][i + 1] + dp[i][i];
            for (int j = 1; j <= i ; j++) {
                dp[i + 1][j] = Math.max(dp[i][j - 1] + triangle[i + 1][j], dp[i][j] + triangle[i + 1][j]);
            }
        }

        int ans = -1;

        for (int i : dp[n - 1]) {
            ans = Math.max(ans, i);
        }

        System.out.println(ans);

    }
    
}
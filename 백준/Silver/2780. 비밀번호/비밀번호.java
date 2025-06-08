import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] mx = {0, 0, 1, -1};
    public static int[] my = {1, -1, 0, 0};
    public static int[][] dp = new int[1000][10];
    public static int[] ans;

    public static int n;

    public static int[][] doorLock = {
        {7},
        {2, 4},
        {1, 3, 5},
        {2, 6},
        {1, 5, 7},
        {2, 4, 6, 8},
        {3, 5, 9},
        {4, 8, 0},
        {5, 7, 9},
        {6, 8}
    };

    public static int mod = 1_234_567;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ans = new int[1001];

        Arrays.fill(dp[0], 1);
        ans[0] = 10;

        for (int i = 1; i<1000; i++){

            for (int j =0; j <10; j++){
                for (int num : doorLock[j]){
                    dp[i][j] += dp[i-1][num];
                }
                dp[i][j] %= mod;
            }

            for (int j =0; j <10; j++){
                ans[i] += dp[i][j];
                ans[i] %= mod;
            }

        }

        n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(ans[num-1]);
        }

    }

}
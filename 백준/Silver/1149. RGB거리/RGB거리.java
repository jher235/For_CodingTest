import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N][3];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        dp[0][0] = Integer.parseInt(stringTokenizer.nextToken());
        dp[0][1] = Integer.parseInt(stringTokenizer.nextToken());
        dp[0][2]= Integer.parseInt(stringTokenizer.nextToken());

        // 현재 선택한 색깔의 총 비용 = 현재 선택한 색깔 + 이전 선택 색깔 중 다른 색깔의 최소값
        for (int i=1;i<N;i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(stringTokenizer.nextToken());
            int G = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            dp[i][0] = R + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = G + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = B + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
    
}
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dp;

    static int c;

    static final int MAX_VALUE = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        dp = new int[c+101];

        Arrays.fill(dp, MAX_VALUE);

        dp[0] = 0;

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j=0; j<c+101; j++){
                if(value <= j){
                    dp[j] = Math.min(dp[j], dp[j-value] + cost);
                }
            }

        }

        int ans = MAX_VALUE;

        for (int i=c; i< c+101; i++){
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }

}
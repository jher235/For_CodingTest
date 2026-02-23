import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    private static int N, M;

    private static int[][] dp;

    private static int[] man;
    private static int[] women;

    private static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int V; // N, M 중 더 적은 쪽
        int U;

        // 항상 MAN 쪽이 더 적거나 같도록 함. 편의를 위해
        if(N<=M){
            man = new int[N];
            women = new int[M];

            V = N;
            U = M;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                man[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                women[i] = Integer.parseInt(st.nextToken());
            }
        }else {
            man = new int[M];
            women = new int[N];

            V = M;
            U = N;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                women[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                man[i] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[V + 1][U + 1];

        Arrays.sort(man);
        Arrays.sort(women);

        for (int i=1; i<=V;i++){
            for (int j = i; j<=U; j++){
                if(i == j){
                    dp[i][j] = dp[i-1][j-1] + Math.abs(man[i-1] - women[j-1]);
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + Math.abs(man[i-1] - women[j-1]), dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[V][U]);
    }

}
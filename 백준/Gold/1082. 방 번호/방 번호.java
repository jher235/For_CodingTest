import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static int N, M;

    private static int[] p;

    private static String[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        p = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            // i가 value, p[i]가 cost
            p[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        dp = new String[M+1];

        Arrays.fill(dp, "0");

        for (int i=0; i<N; i++){
            if(p[i] > M) continue;
            dp[p[i]] = maxValue(String.valueOf(i), dp[p[i]]);
        }


        for (int i=1; i<=M; i++){
            for (int j =0 ;j<p.length; j++){
                int cost = p[j];
                if(cost < i){
                    dp[i] = maxValue(dp[i-cost] + String.valueOf(j), dp[i]);
                }
            }
        }


        System.out.println(dp[M]);

        // 비용이 적은데, 큰 수만 남기기.
        // 가장 적은 비용부터 추출해서 스택에 넣고
        // 0을 제외
        // 반대로 뽑아서 출력




    }

    private static String maxValue(String v1, String v2){

        while (v1.startsWith("0") && v1.length() > 1){
            v1 = v1.substring(1);
        }

        while (v2.startsWith("0") && v2.length() > 1){
            v2 = v2.substring(1);
        }

        if(v1.length() > v2.length()){
            return v1;
        }else if(v1.length() < v2.length()){
            return v2;
        }

        for (int i = 0; i<v1.length(); i++){
            if(v1.charAt(i) > v2.charAt(i)){
                return v1;
            } else if (v1.charAt(i) < v2.charAt(i)) {
                return v2;
            }
        }

        return v1;
    }


}

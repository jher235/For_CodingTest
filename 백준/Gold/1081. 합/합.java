import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 추후 다시 풀기... 수학 너무 어렵네

// 참고
// https://beudicri.tistory.com/169
// https://download1324.tistory.com/173


public class Main {

    private static String L, U;
    private static long ans = 0;

    private static int len;

    private static long[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = st.nextToken();
        U = st.nextToken();

        len = U.length();
        dp = new long[len + 1][10];

        for (int i=0; i<10; i++){
            dp[0][i] = i;
        }

        dp[1][0] = 45;
        for (int i =1; i<=len; i++){

            dp[i][0] = (dp[i-1][0] + dp[i-1][9]) * 5;

            for (int j=1; j<10; j++){
                dp[i][j] = dp[i][0] + (long)Math.pow(10, i) * j;
            }

        }

        System.out.println(sum(Long.parseLong(U)) - sum(Long.parseLong(L)-1));
    }

    private static long sum(long n) {
        if(n <= 0) {
            return 0;
        }
        int pow = (int) Math.log10(n);         // 자리수 10의 n승
        long k = (long) Math.pow(10, pow);    // 현재 숫자의 단위
        long r = n / k;                         // 맨 앞자리수 r = 4
        long remain = (n - (r * k));               // 나머지 수


        long res = (remain + 1) * r;

        for(int i = 0; i < r; i++) {
            // System.out.println(dp[pow][i]);
            res += dp[pow][i];
        }
        // System.out.println("-----------");
        // System.out.println(res);
        // System.out.println("-----------");

        return res + sum(remain);
    }

}
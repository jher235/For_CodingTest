

import java.io.*;
import java.util.function.Function;

public class Main {

    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int mod = 1000_000_000;

        // 현재 자릿수
        // 0~10 현재 숫자
        // 비트마스킹 배열
        int[][][] dp = new int[N][10][1 << 11];

        //0부터 시작하는 수는 없으므로 1부터 반복
        for (int i = 1; i < 10; i++) {
            dp[0][i][1 << i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k =0;k<1024;k++){
                    if(j-1 >= 0){ // k | 1 << j: 현재 숫자 j를 사용했음을 비트마스크에 추가
                        dp[i][j][k | 1 << j] += dp[i-1][j-1][k];
                    }
                    if(j+1 < 10){
                        dp[i][j][k | 1 << j] += dp[i-1][j+1][k];
                    }
                    dp[i][j][k | 1 << j] %= mod;
                }

            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N-1][i][1023];
            ans %= mod;
        }

        System.out.println(ans);
    }


}


// 참고: https://velog.io/@js43o/%EB%B0%B1%EC%A4%80-1562%EB%B2%88-%EA%B3%84%EB%8B%A8-%EC%88%98
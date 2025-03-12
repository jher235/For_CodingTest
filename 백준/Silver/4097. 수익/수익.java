import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        while (input != 0){
            int[] log = new int[input];
            int[] dp = new int[input+1];

            int max = -10_001;

            for (int i=0; i<input; i++){
                log[i] = Integer.parseInt(br.readLine());
            }
            for (int i=1; i<=input; i++){
                // 지금 입력된 값이 (지금 입력된 값 + 누적 합) 보다 크면 지금 입력된 값으로 초기화
                dp[i] = Math.max(log[i-1], log[i-1] + dp[i-1]);
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
            input = Integer.parseInt(br.readLine());
        }
    }

}
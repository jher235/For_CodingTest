import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1_000_000;
    static int[] dp = new int[MAX + 1];

    static int N;

    static int[] hexa = new int[708];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 육각수 초기 세팅
        int num = 1;
        int up = 5;
        int count = 0;
        while (num < MAX){
            hexa[count++] = num;
            num += up;
            up += 4;
        }

        Arrays.fill(dp, Integer.MAX_VALUE);


        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i=3; i<=MAX; i++){
            for (int j=0; j<count; j++){ // hexa 를 순회하며 최소값 찾기.
                int currentHexa = hexa[j];

                if(i < currentHexa){
                    break;
                }

                dp[i] = Math.min(dp[i-currentHexa] + 1, dp[i]);
            }
        }

        N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
        
    }

}
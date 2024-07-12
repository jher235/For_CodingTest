
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    static String[] staminas;
    static String[] happys;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int stamina = 100;

        staminas = br.readLine().split(" ");
        happys = br.readLine().split(" ");

        dp = new int[n][stamina];

        for (int i=1;i<stamina;i++){
            if(i>=Integer.parseInt(staminas[0])){
                dp[0][i] = Integer.parseInt(happys[0]);
            }
        }

        for(int i=1;i<n;i++){
            for (int j=1;j<stamina;j++){
                if(j-Integer.parseInt(staminas[i]) >= 0 ){
                    dp[i][j] = Math.max(dp[i-1][j], Integer.parseInt(happys[i]) + dp[i-1][j-Integer.parseInt(staminas[i])]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n-1][stamina-1]);
    }
}
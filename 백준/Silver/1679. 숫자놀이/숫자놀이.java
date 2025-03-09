import java.io.*;
import java.util.*;


public class Main {

    public static int[] dp;
    public static int[] num;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        num = new int[n];
        dp = new int[50 * 1000 * 1000];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int k = Integer.parseInt(bufferedReader.readLine());

        for(int i=0;i<dp.length;i++){
            dp[i] = k+1;
        }

        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
            dp[num[i]] = 1;
        }
        dp[0] = 0;

        int ans = 1;
        while(true){
            for(int i=0; i<num.length; i++){
                if(num[i] <= ans){
                   dp[ans] = Math.min(dp[ans], dp[ans - num[i]] + 1);
                }
            }
            if(dp[ans] >= k+1){
                if(ans % 2 == 0){
                    System.out.println("holsoon win at " + ans);
                }else {
                    System.out.println("jjaksoon win at " + ans);
                }
//                for(int j=0; j<=ans; j++){
//                    System.out.println(j + ": " + dp[j]);
//                }
                return;
            }
            ans++;
        }
    }


}
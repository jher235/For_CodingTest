import java.io.*;
import java.util.*;


public class Main {

    public static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] tetra = new int[121];

        dp = new int[n+1];

        int increment = 2; //사면체 별로 늘어나는 대포알의 수
        int pre = 3; //이전 사면체의 대포알 수

        tetra[0] = 1;
        for(int i=1; i<tetra.length; i++){ //
            tetra[i] = tetra[i -1] + pre;
            increment++;
            pre += increment;
        }

        Arrays.fill(dp, 300_000);
        dp[0] = 0;

        for(int i=1;i<n+1;i++){
            for(int j=0;j<tetra.length;j++){
                if(i >= tetra[j]){
                    dp[i] = Math.min(dp[i], dp[i - tetra[j]] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }

}
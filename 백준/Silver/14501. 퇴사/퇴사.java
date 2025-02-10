import java.io.*;
import java.util.*;


public class Main {

    public static int N;
    public static int[] dp;
    public static schedule[] schedules;

    public static class schedule{
        int costDay;
        int reword;
        public schedule(int day, int reword){
            this.costDay = day;
            this.reword = reword;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        dp = new int[N+1];
        schedules = new schedule[N];

        for (int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int day = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());
            schedules[i] = new schedule(day, cost);
        }

        if(schedules[N-1].costDay < 2){
            dp[N-1] = schedules[N-1].reword;
        }

        for (int i=N-2;i>=0;i--){
            if(i + schedules[i].costDay > N){
                dp[i] = dp[i+1];
                continue;
            }
            dp[i] =Math.max(dp[i+schedules[i].costDay] + schedules[i].reword,
                    dp[i+1]);
        }

        System.out.println(dp[0]);
        
    }

}
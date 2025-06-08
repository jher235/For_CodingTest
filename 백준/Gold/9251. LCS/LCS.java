import java.io.*;

public class Main {

    public static int[][] dp;

    public static int n;

    public static String[] first;
    public static String[] second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        first = br.readLine().split("");
        second = br.readLine().split("");

        int firstLength = first.length;
        int secondLength = second.length;
        dp = new int[firstLength +1][secondLength +1];

        for (int i = 1; i <= firstLength; ++i){
            for (int j = 1; j<= secondLength; ++j){

                if(first[i-1].equals(second[j-1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        System.out.print(dp[firstLength][secondLength]);
    }

}
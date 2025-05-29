import java.io.*;
import java.util.Arrays;

public class Main {

    public static long[][] arr;
    public static long[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int lastN = n-1;

        arr = new long[n][n];
        ans = new long[n][n];

        for (int i=0;i<n;i++){
            arr[i] = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        }

        ans[lastN][lastN] = 1;

        for (int i=lastN; i>=0; --i){
            for (int j=lastN; j>=0; --j){
                if(i==lastN && j==lastN){
                    continue;
                }
                if(j + arr[i][j] <= lastN){
                    ans[i][j] += ans[i][(int)(j+arr[i][j])];
                }
                if(i + arr[i][j] <= lastN){
                    ans[i][j] += ans[(int)(i+arr[i][j])][j];
                }
            }
        }
        System.out.println(ans[0][0]);
    }
}
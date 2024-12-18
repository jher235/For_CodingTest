
import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][][] attendance = new int[1001][3][2];
    static Long answer = 0L;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        attendance[1][0][0] = 1;
        attendance[1][1][0] = 1;
        attendance[1][0][1] = 1;

        for (int i = 2; i <= n; i++) {
            attendance[i][0][0] = (attendance[i - 1][0][0] + attendance[i - 1][1][0] + attendance[i - 1][2][0]) % 1000000;
            attendance[i][0][1] = (attendance[i - 1][0][1] + attendance[i - 1][1][1] + attendance[i - 1][2][1] + attendance[i][0][0]) % 1000000;

            attendance[i][1][0] = attendance[i - 1][0][0];
            attendance[i][2][0] = attendance[i - 1][1][0];
            attendance[i][1][1] = attendance[i - 1][0][1];
            attendance[i][2][1] = attendance[i - 1][1][1];
        }

        System.out.println((attendance[n][0][0] + attendance[n][0][1] + attendance[n][1][0] + attendance[n][2][0] + attendance[n][1][1] + attendance[n][2][1]) % 1000000);

    }

}
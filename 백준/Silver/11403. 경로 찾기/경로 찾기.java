import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] board;

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new boolean[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                if(Integer.parseInt(stringTokenizer.nextToken()) > 0){
                    board[i][j] = true;
                }
            }
        }

        for (int k=0; k<n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][k] && board[k][j]){
                        board[i][j] = true;
                    }
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(board[i][j]){
                    bw.append("1 ");
                }else {
                    bw.append("0 ");
                }
            }
            bw.append("\n");
        }

        bw.flush();
        bw.close();
    }

}
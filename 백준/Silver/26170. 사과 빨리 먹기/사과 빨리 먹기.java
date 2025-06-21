import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] mx = {0, 0, 1, -1};
    public static int[] my = {1, -1, 0, 0};
    public static int[][] board = new int[5][5];

    public static int n;
    public static int ans = 9999999;
    public static boolean isEnable = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());

        dfs(startX, startY, 0, 0);

        if(isEnable){
            System.out.println(ans);
        }else {
            System.out.println(-1);
        }
    }

    public static void dfs(int x, int y, int countValue, int apple){

        boolean isApple = false;

        if(board[y][x] == 1){
            isApple = true;
            apple++;
        }

        if(countValue >= ans){
            return;
        }

        if (apple == 3){
            isEnable = true;
            ans = countValue;
            return;
        }

        for (int i=0;i<4;i++){
            int nextX = x + mx[i];
            int nextY = y + my[i];

            if(nextY >= 0 && nextY < 5 && nextX >= 0 && nextX < 5){
                if(board[nextY][nextX] != -1){

                    board[y][x] = -1;

                    dfs(nextX, nextY, countValue+1, apple);
                    if(isApple){
                        board[y][x] = 1;
                    }else {
                        board[y][x] = 0;
                    }
                }
            }
        }

    }

}
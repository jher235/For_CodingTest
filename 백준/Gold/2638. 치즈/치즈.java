import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static int n, m;

    static int count = 0;
    static int cheese = 0;

    static int[][] status;


    /**
     * status로 상태를 기록함.
     * -1: 순회함. 공기.
     * 0:  내부 공기.
     * 1: 치즈
     * 2: 치즈에서 공기로 변하는 상태 == 치즈가 한번에 산화하기 위함 + dfs를 위함.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        status = new int[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(stringTokenizer.nextToken());
                if(input == 1){
                    cheese++;
                }
                status[i][j] = input;
            }
        }

        dfs(0, 0);

        while ( cheese > 0){
            count++;
            melt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(status[i][j] == 2){
                        dfs(j,i);
                    }
                }
            }
        }

        System.out.println(count);

    }

    public static void dfs(int x, int y) {

        status[y][x] = -1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                if(status[nextY][nextX]==0 || status[nextY][nextX] == 2){
                    dfs(nextX, nextY);
                }
            }

        }
    }

    static void melt(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( status[i][j] == 1 ) {
                    int expose = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = j + moveX[k];
                        int nextY = i + moveY[k];
                        if(status[nextY][nextX] == -1){
                            expose++;
                        }
                    }
                    if(expose>1){
                        status[i][j] = 2;
                        cheese--;
                    }
                }

            }
        }
    }
}
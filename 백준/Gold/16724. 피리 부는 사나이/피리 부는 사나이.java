import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {

    private static final int[] moveX = {1, -1, 0, 0};
    private static final int[] moveY = { 0, 0 ,1, -1};

    private static int N, M;
    private static int ans = 0;

    private static boolean[][] visited;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input  = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]){
                    dfs(i,j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int y, int x){
        if(visited[y][x]){
            return;
        }
        visited[y][x] = true;

        if(Objects.equals(map[y][x], "D")) {
            dfs(y+1, x);
        }else if(Objects.equals(map[y][x], "U")) {
            dfs(y-1, x);
        }else if(Objects.equals(map[y][x], "R")) {
            dfs(y, x+1);
        }else if(Objects.equals(map[y][x], "L")) {
            dfs(y, x-1);
        }

        for (int i = 0; i < 4; i++){
            int nextY = y + moveY[i];
            int nextX = x + moveX[i];

            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                if(!visited[nextY][nextX]){
                    if(map[nextY][nextX].equals("D") && (nextY + 1 == y)){
                        dfs(nextY, nextX);
                    }else if(map[nextY][nextX].equals("U") && (nextY - 1 == y)){
                        dfs(nextY, nextX);
                    }else if(map[nextY][nextX].equals("L") && (nextX - 1 == x)){
                        dfs(nextY, nextX);
                    }else if(map[nextY][nextX].equals("R") && (nextX + 1 == x)){
                        dfs(nextY, nextX);
                    }
                }
            }
        }
    }

}
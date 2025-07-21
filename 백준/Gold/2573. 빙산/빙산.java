import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] mx = {0, 0, 1, -1};
    static int[] my = {1, -1, 0, 0};
    static int n, m;
    static int[][] arr;
    static int[][] nextArr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        nextArr = new int[n][m];
        int year = 0;

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            nextArr[i] = Arrays.copyOf(arr[i], m);
        }

        while (true){
            year++;
            boolean isEnd = false;
            visited = new boolean[n][m];

            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++) {
                    if(arr[i][j] > 0 && !visited[i][j]){
                        if(isEnd){
                            System.out.println(year-1);
                            return;
                        }
                        isEnd = true;
                        dfs(i, j);
                    }
                }
            }
            if(!isEnd){ // 마지막까지 분리 안된 경우
                System.out.println(0);
                return;
            }

            for (int i=0; i< n; i++){
                arr[i] = Arrays.copyOf(nextArr[i], m);
            }

        }


    }

    private static void dfs(int y, int x){
        visited[y][x] = true;

        for (int i=0;i<4;i++){
            int nx = x + mx[i];
            int ny = y + my[i];
            if(nx >= 0 && nx < m
                && ny >= 0 && ny < n ){
                if(arr[ny][nx] <= 0){
                    nextArr[y][x] -= 1;
                }
                if(arr[ny][nx] > 0 && !visited[ny][nx]){
                    dfs(ny, nx);
                }

            }
        }
    }

}
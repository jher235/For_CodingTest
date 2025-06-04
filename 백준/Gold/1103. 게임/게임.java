import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[][] memoization;
    public static int[][] board;
    public static boolean [][] visited;

    public static int N;
    public static int M;

    public static int[] mx = {0, 0, 1, -1};
    public static int[] my = {1, -1, 0, 0};
    

    public static boolean isCirculation = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memoization = new int[N][M];
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; ++i){
            String[] inputLine = br.readLine().split("");
            for (int j=0; j<M; ++j){
                if(inputLine[j].equals("H")){
                    board[i][j] = -1;
                }else{
                    board[i][j] = Integer.parseInt(inputLine[j]);
                }
            }
        }

        visited[0][0] = true;
        dfs(0, 0, 1);

        if(isCirculation){
            System.out.print(-1);
        }else{
            int max = 0;
            for (int i=0; i<N; ++i){
                for (int j=0; j<M; ++j){
                    max = Math.max(memoization[i][j], max);
                }
            }
            System.out.print(max);
        }

    }

    private static void dfs(int y, int x, int moveCount){

        if(moveCount > memoization[y][x]){
            memoization[y][x] = moveCount;
        }else {
            return;
        }

        for (int i=0;i<4;i++){
            int nextX = x + mx[i] * board[y][x];
            int nextY = y + my[i] * board[y][x];

            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                if(board[nextY][nextX] > 0){ // hole이 아닌 경우.
                    if(!visited[nextY][nextX]){ // 이번 dfs 줄기에서 방문 여부

                        visited[nextY][nextX] = true;
                        dfs(nextY, nextX, moveCount + 1);
                        visited[nextY][nextX] = false;

                    }else if (visited[y][x]){ // 재방문 시
                        isCirculation = true;
                        return;
                    }
                }
            }
        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{

    private static int N;
    private static boolean[][] chessBoard;

    private static int[] ans = new int[2];
    private static boolean[] visitedUp;
    private static boolean[] visitedDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chessBoard = new boolean[N][N];
        visitedUp = new boolean[2 * N];
        visitedDown = new boolean[2 * N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    chessBoard[i][j] = true;
                }else if (num == 0){
                    chessBoard[i][j] = false;
                }
            }
        }

        dfs(0, 0, 0, 0);
        dfs(0, 1, 1, 0);
        System.out.println(ans[0] + ans[1]);
    }

    // even을 시작이 1로 시작하는 경우. 좀 잘못생각했는데 두번째부터 시작하는 경우임.
    private static void dfs(int y, int x, int isEven, int count){
        if(x >= N){
            dfs(y + 1,(isEven + y + 1) % 2, isEven, count);
            return;
        }

        if(y >= N){
            ans[isEven] = Math.max(count, ans[isEven]);
            return;
        }

        if(chessBoard[y][x]){
            if(!visitedUp[y + x]
                && !visitedDown[y - x + N]
            ){
                visitedUp[y + x] = true;
                visitedDown[y - x + N] = true;
                dfs(y, x + 2, isEven, count + 1);
                visitedUp[y + x] = false;
                visitedDown[y - x + N] = false;

            }
        }
        dfs(y, x + 2, isEven, count);

    }
}
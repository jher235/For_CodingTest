import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static int[] mx = {-1 , 1, 0, 0};
    private static int[] my = {0, 0, -1 , 1};

    private static int N, M;

    private static int[][] map;
    private static boolean[][] visited;

    private static PriorityQueue<Ground> grounds
        = new PriorityQueue<>((g1, g2) -> g1.value - g2.value);

    private static class Ground{
        int value;
        int y, x;

        public Ground(int v, int y, int x){
            this.value = v;
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for (int j =0; j<input.length; j++){
                int v = input[j] - '0';
                map[i][j] = v;
                if(i == 0 || j == 0 || i == N-1 || j == M-1){
                    grounds.add(new Ground(v, i, j));
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        while (!grounds.isEmpty()){
            Ground curr = grounds.poll();

            for (int i = 0; i < 4; i++){
                int ny = curr.y + my[i];
                int nx = curr.x + mx[i];

                if(
                    ny >= 0 && ny < N && nx >= 0 && nx < M
                        && !visited[ny][nx]
                ){
                    visited[ny][nx] = true;
                    if(map[ny][nx] < curr.value){
                        ans += curr.value - map[ny][nx];
                        grounds.add(new Ground(curr.value, ny, nx));
                    }else{
                        grounds.add(new Ground(map[ny][nx], ny, nx));
                    }
                }
            }

        }

        System.out.println(ans);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static String[][] floor;
    static boolean[][] visited;

    static int ans = 0;

    private final static String HORIZONTAL = "-";
    private final static String VERTICAL = "|";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        floor = new String[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String[] input = br.readLine().split("");
            for (int j=0; j<M; j++) {
                floor[i][j] = input[j];
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++) {
                if(!visited[i][j]){
                    ans++;
                    // visited[i][j] = true;
                    dfs(floor[i][j], i, j);
                }
            }
        }

        System.out.println(ans);

    }

    public static void dfs(String type, int y, int x){
        if(type.equals(HORIZONTAL)){
            while (x<M){
                if(floor[y][x].equals(HORIZONTAL)){
                    visited[y][x] = true;
                    x++;
                }else {
                    return;
                }
            }
        }else if(type.equals(VERTICAL)) {
            while (y<N){
                if(floor[y][x].equals(VERTICAL)){
                    visited[y][x] = true;
                    y++;
                }else {
                    return;
                }
            }
        }
    }
}
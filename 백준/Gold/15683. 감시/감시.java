import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main{

    private static int[] mx = {1, -1, 0, 0};
    private static int[] my = {0, 0, 1, -1};

    private static int N, M;

    private static int[][] map;

    private static List<int[]> cctvs = new ArrayList<>();

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j =0 ;j<M; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input > 0 && input < 6){
                    cctvs.add(new int[]{i, j});
                }
                map[i][j] = input;
            }
        }
        trackingCctv(map, 0);

        System.out.println(ans);
    }

    // 동, 서, 남, 북 -> 0, 1, 2, 3
    private static void watch(int dist, int c, int[][] map){
        int[] cctv =cctvs.get(c);

        int ny = cctv[0];
        int nx = cctv[1];
        while (true){
            nx += mx[dist];
            ny += my[dist];

            if(
                nx >=0 && nx < M && ny >=0 && ny < N
                    && map[ny][nx] != 6
            ){
                if(map[ny][nx] >= 1){ // 다른 cctv
                    continue;
                }
                map[ny][nx] = -1;
            }else {
                break;
            }
        }
    }

    private static int[][] copyMap(int[][] map){
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i=0; i< map.length; i++){
            copyMap[i] = map[i].clone();
        }

        return copyMap;
    }

    private static void trackingCctv(int[][] map, int c){

        // cctv 다 사용중인 경우
        if(c >= cctvs.size()){
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0){
                        count++;
                    }
                }
            }

            ans = Math.min(count, ans);
            return;
        }

        int [][] copyMap;

        int[] cctv = cctvs.get(c);
        int y = cctv[0];
        int x = cctv[1];

        if(map[y][x] == 1){
            for (int i=0; i<4; i++){
                copyMap = copyMap(map);
                watch(i, c, copyMap);
                trackingCctv(copyMap, c+1);
            }
        }

        if(map[y][x] == 2){
            for (int i=0; i<3; i+=2){
                copyMap = copyMap(map);
                watch(i, c, copyMap);
                watch(i + 1, c, copyMap);
                trackingCctv(copyMap, c+1);
            }
        }

        if(map[y][x] == 3){
            for (int i=0; i<2; i++){
                for (int j=2; j<4; j++){
                    copyMap = copyMap(map);
                    watch(i, c, copyMap);
                    watch(j, c, copyMap);
                    trackingCctv(copyMap, c+1);
                }
            }
        }

        if(map[y][x] == 4){
            for (int i=0; i<4; i++){
                copyMap = copyMap(map);
                watch(i, c, copyMap);
                watch((i + 1) % 4 , c, copyMap);
                watch((i + 2) % 4 , c, copyMap);
                trackingCctv(copyMap, c+1);
            }
        }

        if(map[y][x] == 5){
            copyMap = copyMap(map);
            for (int i=0; i<4; i++){
                watch(i, c, copyMap);
            }
            trackingCctv(copyMap, c+1);
        }

    }
}

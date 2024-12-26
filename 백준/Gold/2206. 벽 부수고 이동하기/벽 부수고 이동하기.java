import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static int n, m;

    static boolean[][] map;
    static boolean[][][] check; // 방문 처리 시에는 벽을 부수고 방문한 경우와 그렇지 않은 경우를 구별해서 처리함.

    static int ans = Integer.MAX_VALUE;

    static Queue<BfsRequest> queue = new LinkedList();

    static class BfsRequest{
        private int x;
        private int y;
        private int count;
        private boolean isCrashed;

        BfsRequest(int x, int y, int count, boolean isCrashed){
            this.x = x;
            this.y = y;
            this.count = count;
            this.isCrashed = isCrashed;
        }

        void runBfs(){
            bfs(x, y, count, isCrashed);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        map = new boolean[n][m];
        check = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                boolean inputStatus = input.charAt(j) == '1';
                map[i][j] = inputStatus;
            }
        }
        queue.add(new BfsRequest(0, 0, 1, false));
        check[0][0][0] = true;
        check[0][0][1] = true;

        while (!queue.isEmpty()){
            BfsRequest bfsRequest = queue.poll();
            bfsRequest.runBfs();
        }

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    public static void bfs(int x, int y, int count, boolean isCrashed){
//        if(isCrashed){ // 메모리 초과를 해결하기 위해 방문 즉시 체크하도록 수정함.
//            check[y][x][1] = true;
//        }else{
//            check[y][x][0] = true;
//        }

        if(x == m-1 && y == n-1){
            ans = Math.min(ans, count);
            return;
        }

        for (int i=0;i<4;i++){
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n){
                if(isCrashed){ //벽을 이미 한번 부순 경우
                    if(!check[nextY][nextX][1]){ // 벽을 부순 흐름이 방문 안했다면
                        if(!map[nextY][nextX]){ // 벽이 없으면
                            queue.add(new BfsRequest(nextX, nextY, count+1, isCrashed));
                            check[nextY][nextX][1] = true;
                        }
                    }
                } else { //벽을 아직 부수지 않은 경우
                    if (!check[nextY][nextX][0]) { // 벽을 부수지 않은 흐름이 방문 안했다면
                        if (!map[nextY][nextX]) { // 벽이 없으면
                            queue.add(new BfsRequest(nextX, nextY, count+1, isCrashed));
                            check[nextY][nextX][0] = true;
                        }
                        if(map[nextY][nextX]){ // 벽이 있고 isCrashed 가 false면 벽을 부숨
                            queue.add(new BfsRequest(nextX, nextY, count+1, true));
                            check[nextY][nextX][1] = true;
                        }
                    }
                }
            }
        }

    }

}
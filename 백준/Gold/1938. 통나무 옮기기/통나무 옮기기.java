import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {

    static class Log{
        boolean isVertical;
        int curX;
        int curY;

        int moved;

        public Log(boolean isVertical, int curX, int curY) {
            this.isVertical = isVertical;
            this.curX = curX;
            this.curY = curY;
            this.moved = 0;
        }

        public Log(boolean isVertical, int curX, int curY, int moved) {
            this.isVertical = isVertical;
            this.curX = curX;
            this.curY = curY;
            this.moved = moved;
        }
    }

    static int[] mx = {0, 0, 1, -1};
    static int[] my = {1, -1, 0, 0,};

    static int[] mxForRotation = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] myForRotation = {1, -1, 0, 0, 1, -1, 1, -1};

    static int N;
    static int ans = 0;
    static boolean[][] map;
    static Log dest;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        Log current = null;
        dest = null;

        int firstBRow = -1;
        int firstERow = -1;
        /**
         * 초기화. 두번째까지의 통나무 위치만을 가져와서 통나무 위치를 초기화함. 같은 열에 위치하는지를 기준으로.
         */
        for (int i=0; i<N; i++){
            String[] inputs = br.readLine().split("");

            for (int j=0; j<N; j++) {
                if(inputs[j].equals("0")){
                    map[i][j] = true;
                } else if(inputs[j].equals("1")){
                    map[i][j] = false;
                } else if(inputs[j].equals("B")){
                    if(firstBRow < 0){
                        firstBRow = i;
                    }else if (current == null){
                        if(firstBRow == i){
                            current = new Log(false, j, i);
                        }else {
                            current = new Log(true, j, i);
                        }
                    }
                    map[i][j] = true;
                } else if(inputs[j].equals("E")){
                    if(firstERow < 0){
                        firstERow = i;
                    }else if (dest == null){
                        if(firstERow == i){
                            dest = new Log(false, j, i);
                        }else {
                            dest = new Log(true, j, i);
                        }
                    }
                    map[i][j] = true;
                }
            }
        }


        bfs(current);

        System.out.println(ans);

    }

    private static void bfs(Log start){
        Queue<Log> queue = new LinkedList<>();

        boolean[][][] visited = new boolean[N][N][2];

        queue.add(start);
        visited[start.curY][start.curX][booleanToInt(start.isVertical)] = true;

        while (!queue.isEmpty()){
            Log current = queue.poll();

            int curX = current.curX;
            int curY = current.curY;
            boolean curIsVertical = current.isVertical;
            int curMoved = current.moved;

            // System.out.println("cur Y & X: "+  curY + ", " + curX + ", count = " + curMoved + ", is vertical: " + curIsVertical);

            boolean rotationAble = true;

            for (int i=0; i<8; i++){
                int nx = curX + mxForRotation[i];
                int ny = curY + myForRotation[i];
                if(nx < 0 || nx >= N
                    || ny < 0 || ny >= N
                    || !map[ny][nx]
                ){
                    rotationAble = false;
                }
            }
            if(rotationAble && !visited[curY][curX][booleanToInt(!curIsVertical)]){
                queue.add(new Log(!curIsVertical, curX, curY, curMoved + 1));
                visited[curY][curX][booleanToInt(!curIsVertical)] = true;
            }

            for (int i=0; i<4; i++){
                int nx = curX + mx[i];
                int ny = curY + my[i];

                if(curIsVertical){
                    if(ny-1<0||ny+1>=N||nx<0||nx>=N)
                        continue;
                    if(!map[ny+1][nx]||!map[ny-1][nx]||!map[ny][nx])
                        continue;

                }else{
                    if(ny<0||ny>=N||nx-1<0||nx+1>=N)
                        continue;
                    if(!map[ny][nx+1]||!map[ny][nx-1]||!map[ny][nx])
                        continue;
                }

                if(visited[ny][nx][booleanToInt(curIsVertical)]) {
                    continue;
                }


                if(dest.curY == ny &&  dest.curX == nx ){
                    // System.out.println("dest: "+  dest.curY + ", " + dest.curX);
                    if(dest.isVertical == curIsVertical){
                        // ans = curMoved + 1;
                        if(ans > 0){
                            ans = Math.min(ans, curMoved + 1);
                        }else{
                            ans = curMoved + 1;
                        }
                    }else {
                        // ans = curMoved + 2;
                        if(ans > 0){
                            ans = Math.min(ans, curMoved + 2);
                        }else{
                            ans = curMoved + 2;
                        }
                    }
                    // return;
                }

                visited[ny][nx][booleanToInt(curIsVertical)] = true;

                queue.add(new Log(curIsVertical, nx, ny, curMoved +1));

            }

        }

    }

    private static int booleanToInt(boolean bool){
        return bool ? 1 : 0;
    }

}
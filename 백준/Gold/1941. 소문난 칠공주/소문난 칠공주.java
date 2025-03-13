import java.io.*;
import java.util.*;


public class Main {

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    static int ans = 0;
    static boolean[] totalVisited = new boolean[25];
    static char[][] map;

    // 25C7를 전부 찾음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];

        for (int i=0; i < map.length; i++ ){
            String input = br.readLine();
            for (int j=0; j < map[i].length; j++ ){
                map[i][j] = input.charAt(j);
            }
        }

        search(0, 0, 0);
        System.out.println(ans);
    }


    private static void search(int idx, int depth, int countY){
        if(countY >= 4){
            return;
        }

        if(depth >= 7){
            int curIdx = idx - 1;
            if(bfs(curIdx % 5, curIdx / 5)){
                ans++;
            }
            return;
        }

        for (int i = idx; i<25;i++){
            totalVisited[i] = true;

            // 이걸 선택하고 다음으로 넘어가는 것.
            if(map[i/5][i%5] == 'Y'){
                search(i+1, depth+1, countY+1);
            }else {
                search(i+1, depth+1, countY);
            }
            totalVisited[i] = false;
        }

    }


    private static boolean bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] tempVisited = new boolean[5][5];
        tempVisited[y][x] = true;
        int count = 1;

        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i=0; i<4;i++){
                int nx = curX + mx[i];
                int ny = curY + my[i];
                if(nx >=0 && nx <5
                        && ny >=0 && ny<5
                        && totalVisited[(ny * 5) + nx] == true
                        && tempVisited[ny][nx] == false){
                    tempVisited[ny][nx] = true;
                    count++;
                    queue.add(new int[] {nx, ny});
                }
            }

        }
        if(count >= 7){
            return true;
        }

        return false;

    }

}


// https://yabmoons.tistory.com/117
// https://tussle.tistory.com/1129
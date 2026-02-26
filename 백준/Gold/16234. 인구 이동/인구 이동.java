import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static int[] mx = {0, 0, 1, -1};
    private static int[] my = {1, -1, 0, 0};

    private static int N, L, R;

    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int [N][N];
//        visited = new boolean [N][N];


        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 라운드마다 한번에 평균을 내야하니까 즉석으로 하면 안되네

//        한 곳이라도 국경선이 열린적 있는지 플래그를 둠
//            플래그 = false;
//            연합 = 1;
//            리스트에 해당 연합을 담아두며 dfs를 해서 연결된걸 모두 찾은 후 평균 내기.
//            반복문에서 순차적으로 방문하는데, 옆자리가
//            처음 열리면 플래그 true로 둠

        boolean continueFlag = true;
        int round = -1;

        while (continueFlag){

//            for (int i=0;i<N;i++){
//                for (int j=0;j<N;j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();


            visited = new boolean [N][N];
            round++;
            continueFlag = false;

            List<List<int[]>> unions = new ArrayList<>();

            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if(!visited[i][j]){

                        visited[i][j] = true;
                        List<int[]> union = new ArrayList<>();
                        union.add(new int[]{i, j});

                        getUnions(union, i, j);

                        if(union.size() > 1){
                            unions.add(union);
                            continueFlag = true;
                        }
                    }
                }
            }


            for (List<int[]> union: unions){;
                int sum = 0;
                int count = 0;
                for (int[] coordinate : union){
                    sum += map[coordinate[0]][coordinate[1]];
                    count++;
                }

                int arr = sum / count;
                for (int[] coordinate : union){
                    map[coordinate[0]][coordinate[1]] = arr;
                }
            }



        }
        System.out.println(round);

    }

    public static void getUnions(List<int[]> union, int y, int x){

        for (int i=0;i<4;i++) {
            int nextY = y + my[i];
            int nextX = x + mx[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N
                && !visited[nextY][nextX]) {

                int gap = Math.abs(map[y][x] - map[nextY][nextX]);
                if (gap >= L && gap <= R) {
                    visited[nextY][nextX] = true;
                    union.add(new int[]{nextY, nextX});
                    getUnions(union, nextY, nextX);
                }

            }
        }
    }
}

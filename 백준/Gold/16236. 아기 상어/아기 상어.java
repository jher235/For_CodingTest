import java.io.*;
import java.util.*;

public class Main {

    static int[] moveY = {-1, 0, 0, 1};
    static int[] moveX = {0, -1, 1, 0};

    static int n;
    static int[][] space;
    static boolean[][] visited;

    static int fishX;
    static int fishY;

    static int ansTime = 0;
    static int fishSize = 2;
    static int eatCount = 0;

    // 일반 큐를 사용하면 동서남북 방향에 따라 값이 달라질 수 있다.
//    static Queue<Node> queue = new LinkedList<>();
    static PriorityQueue<Node> queue = new PriorityQueue<>(Node::compareTo);

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(o.time != this.time){
                return time - o.time; //시간이 적은 쪽
            } else if (o.y != y) {
                return y - o.y; // y가 위일수록 (값이 작을수록)
            }else{
                return x - o.x; // x가 좌측일수록 (값이 작을수록)
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(stringTokenizer.nextToken());

        space = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(stringTokenizer.nextToken());
                if (input == 9) {
                    fishY = i;
                    fishX = j;
                    space[i][j] = 0;
                    continue;
                }
                space[i][j] = input;
            }
        }

        queue.add(new Node(fishX, fishY, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.y][node.x] = true;
            bfs(node.x, node.y, node.time);
        }

        System.out.println(ansTime);

    }

    static void bfs(int x, int y, int currentTime) {
//        visited[y][x] = true;
        if (space[y][x] != 0 && space[y][x] < fishSize) {
            eatCount++;
            if (eatCount >= fishSize) {
                fishSize++;
                eatCount = 0;
            }
            visited = new boolean[n][n]; // 방문 배열 초기화
            queue.clear();
            ansTime = currentTime;
            space[y][x] = 0;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = y + moveY[i];
            int nextX = x + moveX[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                    && !visited[nextY][nextX] && space[nextY][nextX] <= fishSize) {
                visited[nextY][nextX] = true;
                queue.add(new Node(nextX, nextY, currentTime + 1));
            }
        }

    }

}
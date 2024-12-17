
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] tomato;
    static int m, n, h;
    static int unripeCount = 0;
    static int day = 0;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    static Queue<Point> queue = new LinkedList<>();

    static class Point {
        int x, y, z;
        boolean visited;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.visited = false;
        }
    }

    public static void main(String[] args) throws IOException {
        readInput();

        while (unripeCount > 0 && !queue.isEmpty()) {
            day++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                bfs(queue.poll());
            }
        }


        if (unripeCount == 0) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }

    }

    private static void bfs(Point point) {
        for (int i = 0; i < 6; i++) {
            int movex = point.x + dx[i];
            int movey = point.y + dy[i];
            int movez = point.z + dz[i];

            if ((movex >= 0 && movex < m)
                    && (movey >= 0 && movey < n)
                    && (movez >= 0 && movez < h)) {
                if (tomato[movez][movey][movex] == 0) {
                    tomato[movez][movey][movex] = 1;
                    unripeCount--;
                    queue.add(new Point(movex, movey, movez));
                }
            }
        }

    }

    private static void readInput() throws IOException {
        String[] option = br.readLine().split(" ");
        m = Integer.parseInt(option[0]);
        n = Integer.parseInt(option[1]);
        h = Integer.parseInt(option[2]);

        tomato = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    int state = Integer.parseInt(input[k]);
                    tomato[i][j][k] = state;
                    if (state == 0) {
                        unripeCount++;
                    } else if (state == 1) {
                        queue.add(new Point(k, j, i));
                    }
                }
            }
        }

    }


}
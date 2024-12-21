
import java.io.*;
import java.util.*;


public class Main {

    static int[][] table;

    static int[][] spreadEffected; // table의 변경사항이 순차적으로 반영되는 것이 아니라 한번에 반영되어야되기 이차원 배열을 하나 더 만들어서 처리.
    static int R, C, T;

    static AirCleaner airCleaner = new AirCleaner();

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};


    static class AirCleaner {
        Integer topX;
        Integer topY;
        Integer bottomX;
        Integer bottomY;

        AirCleaner() {
            this.topY = null;
            this.topX = null;
            this.bottomY = null;
            this.bottomX = null;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());

        table = new int[R][C];


        for (int i = 0; i < R; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                table[i][j] = value;
                if (value == -1) {
                    if (airCleaner.topX != null && airCleaner.topY != null) {
                        airCleaner.bottomX = j;
                        airCleaner.bottomY = i;
                    } else {
                        airCleaner.topX = j;
                        airCleaner.topY = i;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spreadInSecond();
            clearInSecond();
        }

        System.out.println(Arrays.stream(table)
                .flatMapToInt(Arrays::stream)
                .filter(number -> number>0)
                .sum());
    }

    static void spreadInSecond() {
        spreadEffected = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (table[i][j] > 0) {
                    int count = 0;
                    int spreadValue = table[i][j] / 5;

                    for (int k = 0; k < 4; k++) {
                        int x = j + moveX[k];
                        int y = i + moveY[k];

                        if (x >= 0 && x < C && y >= 0 && y < R) {
                            if (spreadValue > 0 && table[y][x] != -1) {
//                                table[y][x] += spreadValue;
                                spreadEffected[y][x] += spreadValue;
                                count++;
                            }
                        }
                    }
                    spreadEffected[i][j] -= spreadValue * count;
//                    table[i][j] -= spreadValue * count;

                }
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(spreadEffected[i][j]!=0){
                    table[i][j] += spreadEffected[i][j];
                }
            }
        }

    }


    static void clearInSecond() {
        int topY = airCleaner.topY;
        int bottomY = airCleaner.bottomY;

        for (int i = topY - 1; i > 0; i--) {
            table[i][0] = table[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            table[0][i] = table[0][i + 1];
        }
        for (int i = 0; i < topY; i++) {
            table[i][C - 1] = table[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            table[topY][i] = table[topY][i - 1];
        }


        for (int i = bottomY+1; i < R - 1; i++) {
            table[i][0] = table[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            table[R - 1][i] = table[R - 1][i + 1];
        }
        for (int i = R - 1; i > bottomY; i--) {
            table[i][C - 1] = table[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            table[bottomY][i] = table[bottomY][i - 1];
        }

        table[topY][1] = 0;
        table[bottomY][1] = 0;

    }

}
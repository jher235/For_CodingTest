import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main{

    private static int[] mx = {0, 0, 1, -1};
    private static int[] my = {1, -1, 0, 0};

    private static int N;
    private static int M;

    private static char[][] board;

    private static boolean[][][][] visited;

    public static class Moving{
        int redX;
        int redY;
        int blueX;
        int blueY;
        int round;
//        int lastDirection; // optional 한 부분이지만,,, 살짝의 최적화를 위함.. 관리포인트 증가가 번거로워서 제외

        public Moving(int redX, int redY, int blueX, int blueY, int round) {
            this.redX = redX;
            this.redY = redY;
            this.blueY = blueY;
            this.blueX = blueX;
            this.round = round;
        }
    }

    private static Queue<Moving> movingQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        movingQueue = new LinkedList<>();

        visited = new boolean[N][M][N][M];

        int startRedX = 0;
        int startRedY = 0;
        int startBlueX = 0;
        int startBlueY = 0;

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            char[] inputToChar = input.toCharArray();
            for (int j=0; j<M; j++) {
                if('B'==inputToChar[j]){
                    startBlueX = j;
                    startBlueY = i;
                    board[i][j] = '.';
                }else if('R'==inputToChar[j]){
                    startRedX = j;
                    startRedY = i;
                    board[i][j] = '.';
                }else {
                    board[i][j] = inputToChar[j];
                }
            }
        }

        movingQueue.add(new Moving(startRedX, startRedY, startBlueX, startBlueY, 0));

        while (!movingQueue.isEmpty()){
            Moving current = movingQueue.poll();

            if(current.round >= 10){
                continue;
            }

            for (int i=0; i<4; i++) {

                boolean successFlag = false;
                boolean failFlag = false;

                boolean skipBlue = false;

                int nextRedX = current.redX;
                int nextRedY = current.redY;

                int nextBlueX = current.blueX;
                int nextBlueY = current.blueY;

                while (true){
                    nextRedX += mx[i];
                    nextRedY += my[i];

                    // 성공 플래그를 키고, 겹치지 않도록 위치를 -1로 비켜줌
                    if(board[nextRedY][nextRedX] == 'O'){
                        successFlag = true;
                        nextRedY = -1;
                        nextRedX = -1;
                        break;
                    }

                    if((nextRedY == nextBlueY && nextRedX == nextBlueX)){

                        // 이미 blue를 전부 옮겼고, 다시 겹치려고 하면 red를 이동 취소
                        if(skipBlue){
                            nextRedX -= mx[i];
                            nextRedY -= my[i];
                            break;
                        }

                        skipBlue = true;
                        while (true) {
                            nextBlueX += mx[i];
                            nextBlueY += my[i];

                            if(board[nextBlueY][nextBlueX] == 'O'){
                                failFlag = true;
                                nextBlueX = -1;
                                nextBlueY = -1;
                                break;
                            }

                            if (
                                board[nextBlueY][nextBlueX] == '#'
                                || (nextBlueY == current.redY && nextBlueX == current.redX)
                            ) {
                                nextBlueX -= mx[i];
                                nextBlueY -= my[i];
                                break;
                            }
                        }
                        // 여기서 한번 물러나줘야 그냥 지나가버리는 케이스가 없음
                        nextRedX -= mx[i];
                        nextRedY -= my[i];
                    }

                    if(board[nextRedY][nextRedX] == '#'){
                        nextRedX -= mx[i];
                        nextRedY -= my[i];
                        break;
                    }
                }


                if (!skipBlue){
                    while (true){
                        nextBlueX += mx[i];
                        nextBlueY += my[i];

                        if(board[nextBlueY][nextBlueX] == 'O'){
                            failFlag = true;
                            break;
                        }

                        if(
                            board[nextBlueY][nextBlueX] == '#'
                                || (nextBlueY == nextRedY && nextBlueX == nextRedX)
                        ){
                            nextBlueX -= mx[i];
                            nextBlueY -= my[i];
                            break;
                        }
                    }
                }

                if(failFlag){
                    continue;
                }
                if (successFlag){
                    System.out.println(current.round+1);
                    return;
                }

                if (!visited[nextRedY][nextRedX][nextBlueY][nextBlueX]) {
                    visited[nextRedY][nextRedX][nextBlueY][nextBlueX] = true;
                    movingQueue.add(new Moving(nextRedX, nextRedY, nextBlueX, nextBlueY, current.round + 1));
                }
            }
        }
        System.out.println(-1);

    }

}

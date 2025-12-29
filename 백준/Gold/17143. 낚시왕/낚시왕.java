import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main{

    private static int R;
    private static int C;
    private static int M;

    // y, x
//    private static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[] moving = {-1, 1, 1, -1};
    private static int[] nextDirection = {0, 2, 1, 4, 3};
    private static int[][] sharks; // y, x, 속력, 이동 방향, 크기 // 하... 상어를 클래스로 쓸걸..
    private static boolean[] visited;

    private static int ans = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(M <= 0 ) {
            System.out.println(0);
            return;
        }

        visited = new boolean[M];
        sharks = new int[M][5];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++){
                sharks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<= C; i++){

            // 상어 잡기
            int num = -1;
            int y = Integer.MAX_VALUE;
            for (int j=0; j< M; j++){
                if(visited[j]){
                    continue;
                }
                if(sharks[j][1] == i){
                    if(y > sharks[j][0]){
                        y = sharks[j][0];
                        num = j;
                    }
                }
            }
            if(num >= 0){
                visited[num] = true;
                ans += sharks[num][4];
            }

            // 상어 이동
            int [][] board = new int[R+1][C+1];
            for (int j=0; j< M; j++) {
                if (visited[j]) {
                    continue;
                }

                int move;
                int directionYX;
                if(sharks[j][3] < 3){
                    // y축 이동
                    directionYX = R;
                    move = sharks[j][2] % ((directionYX - 1) * 2); // 아 이것도 첨에 저장할 때 처리하는게 낫겠네

                    // move가 1보다 클 경우 반복
                    // 위면, 0 보다 move가 클 경우 맨 위까지 이동 후 방향 변경
                    // 0 보다 작으면 그만큼 이동
                    // 아래면, R 보다 move클 경우 맨 아래까지 이동 후 방향 변경
                    // 0보다 작으면 그만큼 이동

                    while (move > 0){
                        int direction = sharks[j][3];

                        if(direction == 1){ // 위
                            if(sharks[j][0] - 1 <= move ){
                                move -= sharks[j][0] - 1;
                                sharks[j][0] = 1;
                                sharks[j][3] = nextDirection[direction];
                            }else {
                                sharks[j][0] -= move;
                                move = 0;
                            }
                        }else if (direction == 2){ // 아래
                            if (sharks[j][0] + move >= directionYX){
                                move -= directionYX - sharks[j][0];
                                sharks[j][0] = directionYX;
                                sharks[j][3] = nextDirection[direction];
                            }else {
                                sharks[j][0] += move;
                                move = 0;
                            }
                        }
                    }

                }else{
                    directionYX = C;
                    move = sharks[j][2] % ((directionYX - 1) * 2);

                    while (move > 0){
                        int direction = sharks[j][3];

                        if(direction == 4){ // 왼쪽일때
                            if(sharks[j][1] - 1 <= move ){
                                move -= sharks[j][1] - 1;
                                sharks[j][1] = 1;
                                sharks[j][3] = nextDirection[direction];
                            }else {
                                sharks[j][1] -= move;
                                move = 0;
                            }
                        }else if (direction == 3){ // 오른쪽일때
                            if (sharks[j][1] + move >= directionYX){
                                move -= directionYX - sharks[j][1];
                                sharks[j][1] = directionYX;
                                sharks[j][3] = nextDirection[direction];
                            }else {
                                sharks[j][1] += move;
                                move = 0;
                            }
                        }
                    }
                }

                // 여긴 야매로... 인덱스를 + 1해서 저장함. 기본 값인 0과 충돌하지 않도록...
                int currentJ = j + 1;
                int preJ = board[sharks[j][0]][sharks[j][1]] - 1; // 그래서 꺼낸값 - 1 을 해줌..
                if( preJ == -1){
                    board[sharks[j][0]][sharks[j][1]] = currentJ;
                }else {
                    if (sharks[preJ][4] > sharks[j][4]){
                        visited[j] = true;
                    }else {
                        visited[preJ] = true;
                        board[sharks[j][0]][sharks[j][1]] = currentJ;
                    }
                }

            }
        }
        System.out.println(ans);
    }

}
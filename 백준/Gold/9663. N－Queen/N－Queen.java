import java.io.*;
import java.util.*;


public class Main {

    public static boolean[][] arr;
    public static int N;

    public static boolean[] column;

    //대각선도 끝점이 존재함. 4 * 4라면 7개의 끝점 존재. 상단, 좌측 4+4-1 = 7개
    static boolean[] upDiagonalEndPoint;
    static boolean[] downDiagonalEndPoint;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        arr = new boolean[N][N];

        column = new boolean[N];
        upDiagonalEndPoint = new boolean[2*N-1];
        downDiagonalEndPoint = new boolean[2*N-1];

        solution(0);
        System.out.println(ans);

    }

    private static void solution(int y){ //y축 점유 개수, y축은 항상 0부터 N-1까지 내려가면서 진행함. x가 여기에 맞춤.

        if (y == N){
            ans++;
            return;
        }

        for (int x = 0; x<N;x++){
            if(column[x]==false &&
                    upDiagonalEndPoint[N-1 + y-x]==false &&
                    downDiagonalEndPoint[x+y]==false) {
                column[x]=true; //열에 퀸 유무
                upDiagonalEndPoint[N-1 + y-x] = true;
                downDiagonalEndPoint[x+y]=true;
                solution(y+1);
                column[x]=false;
                upDiagonalEndPoint[N-1 + y-x] = false;
                downDiagonalEndPoint[x+y]=false;
            }
        }

    }

}
import java.io.*;
import java.util.*;


public class Main {

    //x, y축을 동서남북으로 이동하기 위한 배열들
    private static int[] surroundX = {0, 1, 0, -1};
    private static int[] surroundY = {1, 0, -1, 0};
    private static Set<String> numberSet = new HashSet<>();
    private static String[][] numberBoard = new String[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<5;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
            for (int j=0;j<5;j++){
                numberBoard[i][j] = stringTokenizer.nextToken();
            }
        }

        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                String num = "";
                dfs(i,j,6, num);
            }
        }
        System.out.println(numberSet.size());
    }

    //dfs(재귀)를 통해 가능한 모든 수를 탐색한다.
    private static void dfs(int x, int y, int count, String num){
        num += numberBoard[x][y]; //현재 위치 숫자를 이전까지 가져오던 num에 이어붙여줌
        count--;

        if(count<1){ //이동 횟수를 모두 소진한 경우
            numberSet.add(num);
            return;
        }

        for(int i=0;i<4;i++){
            int nextX = x+surroundX[i];
            int nextY = y+surroundY[i];
            if(nextX>=0 && nextX<5 && nextY>=0 && nextY<5) //배열 범위를 넘어서지 않는다면 
                dfs(nextX, nextY, count, num); 
        }
    }
}
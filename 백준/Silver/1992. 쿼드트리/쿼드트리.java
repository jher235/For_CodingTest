import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static int ans;
    private static int N;

    private static boolean[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];

        for (int i=1; i<=N; i++){
            char[] input = br.readLine().toCharArray();
            for (int j=1; j<=N; j++){
                if(input[j-1] == '1'){
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                }
            }
        }


        String ans = compress(1,1, N);

        System.out.println(ans);
    }

    private static String compress(int y, int x, int len){

        boolean b = map[y][x];

        for (int i=y; i<y + len; i++){
            for (int j=x; j<x + len; j++){
                if(b != map[i][j]){
                    int nextLen = len/2;
                    return "("
                        + compress(y, x, nextLen)
                        + compress(y, x + nextLen, nextLen)
                        + compress(y + nextLen, x, nextLen)
                        + compress(y + nextLen, x + nextLen, nextLen)
                        + ")";
                }
            }
        }
        return b ? "1" : "0";
    }


}

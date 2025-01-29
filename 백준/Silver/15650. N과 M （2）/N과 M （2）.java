import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    static int N, M;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[M];


        for (int i=1;i<=N+1-M;i++){
            StringBuilder stringBuilder = new StringBuilder(i+" ");
            solve(1, i, stringBuilder);
        }

    }


    private static void solve(int count, int num, StringBuilder ans){
        if (count>=M){
            System.out.println(ans);
        }
        else if(count < M){
            for (int i=1; i<=N-(M-count)-num+1;i++){ // 여기가 중요함 제한 숫자 - (선택 개수 - 현재 개수) - 지금 숫자 +1
                solve(count+1, num+i, new StringBuilder(ans).append(num+i).append(" "));
            }
        }
    }
}
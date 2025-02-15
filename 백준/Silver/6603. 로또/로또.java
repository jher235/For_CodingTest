import java.io.*;
import java.util.*;


public class Main {

    public static int[] num;
    public static int[] S;
    public static boolean[] check;
    public static int K, currentPoint, endPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            K = Integer.parseInt(stringTokenizer.nextToken());

            if(K ==0){
                return;
            }

            num = new int[K];
            S = new int[K];
            check = new boolean[K];
            for (int i=0;i<K;i++){
                S[i] = Integer.parseInt(stringTokenizer.nextToken());
                if(i<6){
                    check[i] = true;
                }
            }
            currentPoint = 5;
            endPoint = K-1;

            print(0,0);
            System.out.println();
        }

    }

    // 사싱상 다중 for 문처럼 재귀가 발생
    public static void print(int currentPoint, int depth){

        if (depth>=6){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0;i<6;i++){
                stringBuilder.append(num[i]).append(" ");
            }
            System.out.println(stringBuilder);
            return;
        }


        for (int i=currentPoint;i<K;i++){
            num[depth] = S[i];
            print(i+1, depth+1);
        }
    }

}
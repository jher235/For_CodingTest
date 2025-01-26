import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    static int N;
    static int[] arr;

    static int closeZeroValue = Integer.MAX_VALUE;

    static int firstAns = Integer.MIN_VALUE;
    static int secondAns = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int firstPoint = 0;
        int secondPoint = N-1;


        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }


        while (firstPoint < secondPoint){

            int sum = arr[firstPoint] + arr[secondPoint];
            int absSum = Math.abs(sum);
            if(absSum < closeZeroValue){
                closeZeroValue = absSum;
                firstAns = arr[firstPoint];
                secondAns = arr[secondPoint];
            }

            if(sum > 0){
                secondPoint--;
            }else if (sum < 0){
                firstPoint ++;
            }else {
                System.out.println(firstAns+" "+secondAns);
                return;
            }

        }
        System.out.println(firstAns+" "+secondAns);
    }

}
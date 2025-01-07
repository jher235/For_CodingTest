import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

    static int N, M;

    static int[] ans;

    static LinkedList<Integer> answer = new LinkedList<>();

    //진입차수
    static int[] entryCount;
    static LinkedList<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        entryCount = new int[N+1];

        list = new LinkedList[N+1];
        for (int i=1;i<=N;i++){
            list[i] = new LinkedList<>();
        }

        for (int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int rep = Integer.parseInt(stringTokenizer.nextToken());
            int[] input = new int[rep];
            for (int j=0;j<rep;j++){
                input[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int j=0;j<rep-1;j++){
                int number = input[j];
                int nextNumber = input[j+1];

                list[number].add(nextNumber);
                entryCount[nextNumber]++; //진입 차수 증가
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1;i<=N;i++){
            if (entryCount[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int number = queue.poll();
            answer.add(number);
            list[number].forEach((i)->{
                entryCount[i]--;
                if(entryCount[i] == 0){
                    queue.add(i);
                }
            });
        }

        if(answer.size()<N){
            System.out.println(0);
        }else {
            StringBuilder stringBuilder = new StringBuilder();
            answer.forEach(i->stringBuilder.append(i).append("\n"));
            System.out.println(stringBuilder);
        }

    }


}
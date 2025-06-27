import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int k;

    static int[][] gems;
    static PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        gems = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken());
            gems[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(gems, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        int[] backpack = new int[k];
        for (int i = 0; i < k; i++) {
            backpack[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(backpack);

        long ans = 0L;

        // 우선 순위 큐를 이렇게 하나만 사용하고 백팩에 수용 가능한 보석의 범위만 계속해서 추가해주기 + 그 중 최대값을 선택하기.
        priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        for (int i = 0; i < k; i++) {

            while (index < n && gems[index][0] <= backpack[i]){
                priorityQueue.add(gems[index][1]);
                index++;
            }
            if(!priorityQueue.isEmpty()){
                ans += priorityQueue.poll();
            }
        }

        System.out.println(ans);


    }

    // static class gem{
    //     int cost;
    //     int value;
    //
    //     public gem(int cost, int value) {
    //         this.cost = cost;
    //         this.value = value;
    //     }
    // }

}
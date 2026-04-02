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

//    private static int ans;
    private static int N, S;

    private static int[] start;
    private static int[] fuel;
    private static boolean[] ans;

    private static List<List<Integer>> lower;
    private static List<List<Integer>> upper;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        ans = new boolean[N+1];

        start = new int[N+1];
        fuel = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        ans[S] = true;

        // 갈수 있는 범위를 큐에 다 넣고 ans도 체크. 없어질 때까지 반복.
        while (!q.isEmpty()){
            int cur = q.poll();
            int curStart = start[cur];
            int curFuel = fuel[cur];

            int bigIdx = cur + 1;
            int upMove = curFuel + curStart;
            while (true){
                if(bigIdx > N){
                    break;
                }

                if(start[bigIdx] <= upMove){
                    if(!ans[bigIdx]){
                        q.add(bigIdx);
                        ans[bigIdx] = true;
                    }
                }else {
                    break;
                }

                bigIdx++;
            }

            int downIdx = cur - 1;
            int downMove = curStart - curFuel;

            while (true){
                if(downIdx < 1){
                    break;
                }

                if(start[downIdx] >= downMove){
                    if(!ans[downIdx]){
                        q.add(downIdx);
                        ans[downIdx] = true;
                    }
                }else{
                    break;
                }

                downIdx--;
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i =1; i<=N; i++){
            if(ans[i]){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

    }


}

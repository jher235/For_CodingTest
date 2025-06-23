import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    static List<Integer>[] lists;

    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ans = new int[n];

        int roadCount = 0;

        char[][] edges = new char[n][n];
        // lists = new List[n];
        //
        // for (int i=0; i<n; i++){
        //     lists[i] = new ArrayList<>();
        // }

        for (int i=0; i<n; i++){
            edges[i] = br.readLine().toCharArray();
        }

        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if(edges[i][j] == 'Y' ){
                    queue.add(new int[] {i, j});
                    // lists[i].add(j);
                    roadCount++;
                }
            }
        }

        if(roadCount < m){
            System.out.println(-1);
            return;
        }

        parent = new int[n];
        for (int i=0; i<n; i++){
            parent[i] = i;
        }

        /**
         * 이게 참 애매한게,, 모든 도시가 연결되어야 한다는 조건이 없는데?
         * 집합이 여러개면? 그래서 우선 순위가 높았던 집합에는 M개의 도로가 없었고 다음 집합에 M개의 도로가 있었다면?
         *
         * 근데 예제 3을 보면
         * 5 4
         * NYNNY
         * YNNNY
         * NNNNN
         * NNNNY
         * YYNYN
         *
         * 이런 경우에는 m의 개수를 충족하더라도 모든 정점을 잇지 못해서 실패하는 듯...
         */


        int connectCount = 0;
        Queue<int[]> tempRoad = new LinkedList<>();

        while (!queue.isEmpty()){
            int[] currentRoad = queue.poll();
            if(union(currentRoad[0], currentRoad[1])){
                ans[currentRoad[0]]++;
                ans[currentRoad[1]]++;
                connectCount++;
            }else {
                tempRoad.add(currentRoad);
            }
        }

        if(connectCount < n-1){
            System.out.println(-1);
            return;
        }

        while (connectCount < m){
            int[] currentRoad = tempRoad.poll();
            ans[currentRoad[0]]++;
            ans[currentRoad[1]]++;
            connectCount++;
        }


        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<n; i++){
            stringBuilder.append(ans[i] + " ");
        }

        System.out.println(stringBuilder);
    }

    private static int findParent(int a){
        if(parent[a] == a) {
            return a;
        }
        return findParent(parent[a]);
    }


    private static boolean union(int a, int b){

        a = findParent(a);
        b = findParent(b);
        
        if(a == b) {
            return false;
        }
        else if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
        return true;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main{

    private static int N;
    private static int M;


    private static int[] parents;

    private static int ans = 0;

    private static class Road{
        public int start;
        public int dest;
        public int cost;

        public Road(int start, int dest, int cost){
            this.start = start;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N <= 2){
            System.out.println(0);
            return;
        }

        parents = new int[N+1];
        for (int i=1; i<=N; i++){
            parents[i] = i;
        }


        PriorityQueue<Road> roads = new PriorityQueue<>(
            Comparator.comparing(road -> road.cost));
        for (int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Road road = new Road(start, dest, cost);
            roads.add(road);
        }

        int connection = 0;
        while (!roads.isEmpty()){

            Road road = roads.poll();
            int start = road.start;
            int dest = road.dest;
            int cost = road.cost;

            int startParent = getParent(start);
            int destParent = getParent(dest);

            if(startParent != destParent){
                union(start, dest);
                ans += cost;
                connection++;
            }

            if(connection >= N-2){
                System.out.println(ans);
                return;
            }

        }
        return;
    }

    private static int getParent(int idx){
        if(parents[idx] == idx) return idx;
        return parents[idx] = getParent(parents[idx]); // 경로 압축
    }

    private static void union(int idx1, int idx2){
        int parent1 = getParent(idx1);
        int parent2 = getParent(idx2);

        if (parent1 < parent2){
            parents[parent2] = parent1;
        }else{
            parents[parent1] = parent2;
        }
    }

}
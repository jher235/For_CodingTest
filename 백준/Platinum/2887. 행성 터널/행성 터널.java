import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main{

    private static int N;

    private static int[] parents;

    private static long ans = 0;


    private static PriorityQueue<Tunnel> tunnelQueue;

    private static class Tunnel{
        public int planet1;
        public int planet2;
        public int cost;

        public Tunnel(int planet1, int planet2, int cost){
            this.planet1 = planet1;
            this.planet2 = planet2;
            this.cost = cost;
        }
    }

    private static class Planet{
        public int index;
        public int x, y, z;

        public Planet(int index, int x, int y, int z){
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static Planet[] planets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        planets = new Planet[N];
        tunnelQueue = new PriorityQueue<>((t1, t2)
            -> Integer.compare(t1.cost, t2.cost));

        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Planet(i, x, y, z);
        }

        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.x, p2.x));
        for (int i = 0; i < N-1; i++){
            Planet planet1 = planets[i];
            Planet planet2 = planets[i + 1];

            Tunnel tunnel = new Tunnel(planet1.index, planet2.index, Math.abs(planet1.x - planet2.x));
            tunnelQueue.add(tunnel);
        }

        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.y, p2.y));
        for (int i = 0; i < N-1; i++){
            Planet planet1 = planets[i];
            Planet planet2 = planets[i + 1];

            Tunnel tunnel = new Tunnel(planet1.index, planet2.index, Math.abs(planet1.y - planet2.y));
            tunnelQueue.add(tunnel);
        }

        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.z, p2.z));
        for (int i = 0; i < N-1; i++){
            Planet planet1 = planets[i];
            Planet planet2 = planets[i + 1];

            Tunnel tunnel = new Tunnel(planet1.index, planet2.index, Math.abs(planet1.z - planet2.z));
            tunnelQueue.add(tunnel);
        }


        while (!tunnelQueue.isEmpty()){
            Tunnel tunnel = tunnelQueue.poll();
            boolean result = union(tunnel.planet1, tunnel.planet2);

            if(result){
                ans += tunnel.cost;
            }
        }

        System.out.println(ans);
    }

    public static boolean union(int p1Idx, int p2Idx){
        int p1Parent = getParent(p1Idx);
        int p2Parent = getParent(p2Idx);

        if (p1Parent == p2Parent){
            return false;
        }else if (p1Parent > p2Parent){
            parents[p1Parent] = p2Parent;
        }else {
            parents[p2Parent] = p1Parent;
        }
        return true;
    }

    public static int getParent(int idx){
        if(idx == parents[idx]) return idx;

        return parents[idx] = getParent(parents[idx]);
    }

}

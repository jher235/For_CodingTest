import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//이전에 사용한 방법과 다르게 백준에서 제시하고 있는 이진탐색, (깊이, 넓이)우선 탐색을 사용하는 방법으로 푼 방식
public class Main {

    private static int n, m;

    private static int start = 1;
    private static int end = Integer.MIN_VALUE;
    private static int startIsland, endIsland;

    private static List<Bridge>[] bridgeCollection;
    private static int[] maximumWeight;// start에서 인덱스 섬까지의 최대 무게를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        maximumWeight = new int[n+1];

        bridgeCollection = new ArrayList[n+1];

        for (int i=0; i<=n ; i++){
            bridgeCollection[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            input = br.readLine().split(" ");
            int islandA = Integer.parseInt(input[0]);
            int islandB = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            start = Math.min(start, weight);
            end = Math.max(end, weight);

            bridgeCollection[islandA].add(new Bridge(islandB, weight));
            bridgeCollection[islandB].add(new Bridge(islandA, weight));
        }
        input = br.readLine().split(" ");
        startIsland = Integer.parseInt(input[0]);
        endIsland = Integer.parseInt(input[1]);

        while(start<=end){
            int mid = (start+end)/2;
            if(bfs(mid)){//bfs로 탐색이 성공한 경우 == 운반이 가능한 무게임
                start = mid+1;
                continue;
            }
            end = mid-1;
        }
        System.out.println(end);
    }

    private static boolean bfs(int mid){
        boolean[] check = new boolean[n+1];
        Queue<Integer> bridgeQueue = new LinkedList<>();

        bridgeQueue.add(startIsland);

        while (!bridgeQueue.isEmpty()){
            int from = bridgeQueue.poll();

            if(check[from]==true){ //같은 섬에도 다리가 여러개 일 수 있기 때문에 큐에 들어가 있는 섬 중에도 이미 탐색한 섬이라면 넘어간다.
                continue;
            }

            check[from] = true;

            for (Bridge bridge : bridgeCollection[from]){
                int destination = bridge.destination;
                if(bridge.weight >= mid && !check[destination]){ //무게 제한에 걸리지 않고, 아직 순회하지 않은 목적지 섬이라면 큐에 추가.
                    if(destination == endIsland){
                        return true;
                    }
                    bridgeQueue.add(destination);
                }
            }
        }
        return false;
    }
}

class Bridge {
    int destination;
    int weight;

    public Bridge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int n, m;
    private static int start, end;

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

            bridgeCollection[islandA].add(new Bridge(islandB, weight));
            bridgeCollection[islandB].add(new Bridge(islandA, weight));


        }
        input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        dijkstra();
        System.out.println(maximumWeight[end]);
    }

    private static void dijkstra(){
        //우선 순위 큐를 사용하여 최대 중량이 높은 것부터 처리, 만약 사용하지 않는다면 모든 곳을 돌아보기 때문에 시간 초과가 발생할 것 같다. 
        PriorityQueue<Bridge> priorityQueue = new PriorityQueue<>((a,b) -> b.weight-a.weight);

        priorityQueue.add(new Bridge(start, Integer.MAX_VALUE));
        maximumWeight[start] = Integer.MAX_VALUE;
        
        while (!priorityQueue.isEmpty()){
            Bridge bridge = priorityQueue.poll();
            int from = bridge.destination;
            int weight = bridge.weight;
            if(maximumWeight[from] > weight){ //현재 from까지 도착하는 최대 중량이 기존에 파악했던 from까지 도착하는 최대 중량보다 작은 경우 넘어감.
                continue;
            }
            for (int i=0;i<bridgeCollection[from].size();i++){
                int to = bridgeCollection[from].get(i).destination;
                int weightTo = Math.min(weight, bridgeCollection[from].get(i).weight);
                if(weightTo>maximumWeight[to]){ //현재 최대 중량이 기존에 알고 있던 최대 중량보다 큰 경우에만 계속함
                    maximumWeight[to] = weightTo; //최대 중량 업데이트.
                    priorityQueue.offer(new Bridge(to, weightTo)); //큐에 다음 섬 삽입 
                }
            }
        }
    }
}

class Bridge {
    int destination;
    int weight;

    public Bridge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
}
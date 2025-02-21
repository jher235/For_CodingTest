import java.util.*;

class Solution {
    
    
    List<Node>[] graph;
    boolean[] visit;
    int answer = 0;
    
     // 우선순위 큐를 사용하는게 좋을 듯
    PriorityQueue<Node> pQ = new PriorityQueue<Node>((n1, n2)-> n1.getCost() - n2.getCost());
        
    public static class Node{
        int number;

        int cost;
        
        public Node(int number, int cost){
            this.number = number;
            this.cost = cost;
        }
        
        public int getCost(){
            return this.cost;
        }
        
         public int getNumber(){
            return this.number;
        }
    } 
    
    public int solution(int n, int[][] costs) {
        
        visit = new boolean[n+1];
        
        int count = 0;
        
        graph = new ArrayList[n+1];
        
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<Node>();
        }
        
        for(int[] cost: costs){
            int p1 = cost[0];
            int p2 = cost[1];
            int costValue = cost[2];
            
            graph[p1].add(new Node(p2, costValue));
            graph[p2].add(new Node(p1, costValue));
            
        }
        
        visit[0] = true;
        
        for(Node node : graph[0]){
            pQ.add(node);
        }
        
        while(!pQ.isEmpty()){
            
            Node node = pQ.poll();
            
            if(visit[node.getNumber()]){
                continue;
            }
            
            visit[node.getNumber()] = true;
            answer += node.getCost();
      
            for(Node newNode : graph[node.getNumber()]){
                    pQ.add(newNode);
            }
            
        }
        
        return answer;
    }
    
}
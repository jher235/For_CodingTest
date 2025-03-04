import java.util.*;
class Solution {
    public static List<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
    
        graph = new ArrayList[n+1];
        int[] answer = new int[sources.length];
        
        
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int start = road[0];
            int end = road[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        for(int i=0; i<sources.length; i++){
            boolean[] visited = new boolean[n+1];
            answer[i] = bfs(sources[i], destination, graph, visited);
        }
        
        
        return answer;
    }
    
    private static int bfs(int start, int target, List<Integer>[] graph, boolean[] visited){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        
        if(start == target) return 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int point = current[0];
            int time = current[1];
            
            for(Integer next : graph[point]){
                if(visited[next]) continue;
                
                if(next == target){
                    return time + 1;
                }
                
                visited[next] = true;
                queue.add(new int[]{next, time + 1});
            }
        }
        return -1;
        
    }
}
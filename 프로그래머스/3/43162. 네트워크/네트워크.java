class Solution {
    static boolean[] visited;
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                visited[i] = true;
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int[][] computers, int current){
        
        for(int i=0;i<computers.length;i++){
            if(computers[current][i] == 1 && visited[i]==false){
                visited[i] = true;
                dfs(computers, i);
            }
        }
    }
}
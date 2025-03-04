class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        // int server = 0;
        for(int i=0;i<players.length;i++){
            if(players[i] >= (server[i] + 1) * m){
                int request = players[i] - (server[i]+1) * m;
                
                int increment = (request)/m + 1;
                
                answer+=increment;
                for(int j=0;(i+j<players.length && j<k);j++){
                    server[i+j] += increment;
                }
            }
        }
        
        return answer;
    }
}
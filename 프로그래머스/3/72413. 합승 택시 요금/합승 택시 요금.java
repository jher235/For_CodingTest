import java.util.*;

class Solution {
    static List<int[]>[] graph;
    static int MAX = 123456789; 
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        // graph = new List[n + 1];
        
        int[][] graphAll = new int[n+1][n+1];
        
        for(int i=0;i<graphAll.length;i++){
            for(int j=0;j<graphAll[i].length;j++){
                if(i == j){
                    graphAll[i][j] = 0;
                    continue;
                }
                graphAll[i][j] = MAX;
            }
        }
        
        for(int[] fare : fares){
            graphAll[fare[0]][fare[1]] = fare[2];
            graphAll[fare[1]][fare[0]] = fare[2];
            
            // graph[fare[0]].add({fare[1], fare[2]});
            // graph[fare[1]].add({fare[0], fare[2]});
        }
        // 다익스트라로 모든 경로의 최소 비용 계산
        for(int k=0;k<=n; k++){
            for(int i=0;i<graphAll.length;i++){
                for(int j=0;j<graphAll[i].length;j++){
                    graphAll[i][j] = 
                        Math.min(graphAll[i][j], 
                                 graphAll[i][k] + graphAll[k][j]);
                }
            }
        }
        
        // s에서 a, b 따로 가는 값
        int answer = graphAll[s][a] + graphAll[s][b];
        
        //다익스트라로 얻은 최소 경로를 바탕으로 정답 도출
        for(int i=1;i<graphAll.length;i++){
            answer = Math.min(answer, 
                              graphAll[s][i] + graphAll[i][a] + graphAll[i][b]);
        }
        
        return answer;
    }
}
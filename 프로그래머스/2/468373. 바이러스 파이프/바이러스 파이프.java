import java.util.*; 

class Solution {
    
    private static int K; // 최대 라운드
    private static int ans = 0;;
    private static int N;
    
    private static boolean[] isV;
    
    private static List<int[]> A = new ArrayList<>();
    private static List<int[]> B = new ArrayList<>();
    private static List<int[]> C = new ArrayList<>();

    public int solution(int n, int infection, int[][] edges, int k) {
        
        // 문제만 읽었을 땐 백트래킹..? 
        
        // 완전히 연관된걸 List로 갖고 처리한다?
        // 완탐 이라면 어짜피 2^10 정도인가..?
        
        K = k;
        isV = new boolean[n+1];
        isV[infection] = true;
        N = n;
        
        
        for(int i=0; i<edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            int p = edges[i][2];
            if(p == 1){
                A.add(new int[]{start, end});
            }
            else if(p == 2){
                B.add(new int[]{start, end});
            }
            else if(p == 3){
                C.add(new int[]{start, end});
            }
        }
        
        slv(0, 0);
        
        
        return ans;
    }
    
    
    public void slv(int round, int lastPipe){
        
        // show();
        
        if(round >= K){
            int cnt = 0;
            for(int i=1; i<=N; i++){
                if(isV[i]) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        
        // 파이프를 하나하나
        for(int i=1; i<4; i++){
            if(lastPipe == i) continue;
            
            List<int[]> list = new ArrayList<>(); 
            if(i == 1){
                list = A;
            }else if(i==2){
                list = B;
            }else if(i==3){
                list = C;
            }
            
            // 여기서 감염시키는 애들을 뽑아두고
            Set <Integer> curV = new HashSet<>();
            
            
            // 라운드 반영 주의하기..
            boolean isChange = true;
            while(isChange){
                isChange = false;
                
                for(int j =0; j<list.size(); j++){
                    int a = list.get(j)[0];
                    int b = list.get(j)[1];

                    if(!isV[a] && isV[b]){
                        isV[a] = true;
                        curV.add(a);
                        isChange = true;
                    }else if(isV[a] && !isV[b]){
                        isV[b] = true;
                        curV.add(b);
                        isChange = true;
                    }

                    // if(i==2){
                    //     show(a, b);
                    // }
                
                }
            }
           
            
            // 재귀 호출
            slv(round + 1, i);
            
            // 풀어주기
            
            List<Integer> curVArr = new ArrayList<>(curV);
            for(int j =0; j<curVArr.size(); j++){
                int cur = curVArr.get(j);
                isV[cur] = false;
            }
            
        }
    
    }
    
    public void show(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(isV[i]).append(" ");
        }
        System.out.println(sb);     
        System.out.println();        
    }
  
        
    public void show(int a, int b){
        
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(isV[a]).append(" : ").append(b).append(isV[b]).append(" : ");
        for(int i=1; i<=N; i++){
            sb.append(isV[i]).append(" ");
        }
        System.out.println(sb);     
        System.out.println();        
    }
  
}
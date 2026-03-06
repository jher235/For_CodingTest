class Solution {
    public int solution(int[][] cost, int[][] hint) {
        
        int ans = Integer.MAX_VALUE;
        
        int bitCount = hint.length;
        
        int maxCase = 1 << bitCount;
        
        for(int i=0; i<maxCase; i++){ // 이건 모든 경우의 수를 보기 위함
            
            int[] hintCount = new int[cost.length];
            int value = 0;
            
            for(int j=0; j<bitCount; j++){ // 이건 비트 자리 수를 비교하기 위함
                
                if((i & (1 << j)) != 0){ // j 부분이 1이라면 == j부분을 구매했다면. 
                    int[] curHint =  hint[j];
                    
                    for(int h = 1; h< curHint.length; h++){
                        int idx = curHint[h]-1;
                        hintCount[idx]++;
                    }
                 
                    value += curHint[0];
                }
            }
        
            
            for(int k=0; k<cost.length; k++){
                
                if(hintCount[k] >= cost[k].length){
                    value += cost[k][cost[k].length - 1];
                }else{
                    value += cost[k][hintCount[k]];
                }
            }
            
            ans = Math.min(ans, value);
            
        }
        
        return ans;
    }
}

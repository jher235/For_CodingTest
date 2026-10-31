

class Solution {
    int ans = 0;
    int target;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {    
        this.target = target;
        this.numbers = numbers;
        
    
        dfs(0, 0);
        return ans;
    }
    
    // 백트래킹으로 하나하나를 전부...
    public void dfs(int curIdx, int sum){
        
        if(curIdx == numbers.length){
            // System.out.println(sum);
            if(sum == target){
                ans++;
            }
            return;
        }
        
        int cur = numbers[curIdx];

        dfs(curIdx + 1, sum + cur);
        dfs(curIdx + 1, sum - cur);
        
    }
    

}
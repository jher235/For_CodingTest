

class Solution {
    static int ans = 0;
    public int solution(int[] numbers, int target) {    
        int sum = 0;
        
        dfs(numbers, 0, 0, target);
        
        return ans;
    }
    
    
    private void dfs(int[] numbers, int depth, int current, int target){
        if(depth == numbers.length -1){ // 마지막이면
            if(current + numbers[depth] == target){
                ans++;
            }else if(current - numbers[depth] == target){
                ans++;
            }
            return;
        }else{
            dfs(numbers, depth+1, current + numbers[depth], target);
            dfs(numbers, depth+1, current - numbers[depth], target);
        }
        
    }
}
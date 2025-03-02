class Solution {
    public long solution(int n, int[] times) {
        long answer = n;
        long max = Long.MIN_VALUE; 
        long min = Long.MAX_VALUE;
        long mid = 0;
        
        for(int time : times){
            min = min < time ? min : time;
            max = max > time ? max : time;
        }
        min *= n;
        min /= times.length;
        max *= n;
        // max /= times.length;
      
        while(min <= max){
            
            mid = (max + min) / 2;
            
            long count = 0;
            for(int time : times){
                count += mid/time;
            }
            
            // System.out.println(count + ", "+ min + ", "+ max + ", "+ mid);

            if(count >= n){
                max = mid - 1;
                
            }else if(count < n){
                min = mid + 1;
            }
        }
   
        return min;
    }
}
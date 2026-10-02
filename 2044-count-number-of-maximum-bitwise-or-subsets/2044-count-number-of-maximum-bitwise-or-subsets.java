class Solution {

    private int mv = 0;
    public int countMaxOrSubsets(int[] nums) {
        
        int ans = 0;

        // 반복문을 이중으로 사용해서 전체탐색.
        // 최대값이라면 mv 를 갱신하는 방식? -> 근데 사실 최대값은 무조건.. 모든 수를 or한 값일텐데..
        for(int i=0; i<nums.length; i++){
            mv = mv | nums[i];
        } 

        // 전체탐색은 쉽게 하려면 재귀를 쓰는게 좋아보임.
         ans = search(0, 0, nums);

        return ans;

    }

    public int search(int cv, int idx, int[] nums){

        if(idx == nums.length - 1){ // 끝까지 온 것

            int v = 0;
            if((cv | nums[idx]) == mv){
                v++;
            }
            if (cv == mv){
                v++;
            }

            return v;
        }
        
        return search(cv, idx + 1, nums) + search(cv | nums[idx], idx + 1, nums);
  
    }
}
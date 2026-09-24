import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        /* 범위가 작은걸로 보아 완탐 
        정렬을 해서 하는게 의미가 있을까?

        수를 다 더한 값
        배열에서 값을 뺏다 더했다하면서...조정? 백트래킹?
        1번을 선택했을 때, 2번을 선택했을 때 안했을 때 
        -> 이렇게 분기를 나눠사면서 전부 탐색한다?  -> 중복을 막기 위해 마킹을 도입?
        이것보다 약간 효율적인건, set 에 합산된 값 관리하기?
        */

        Set<Integer> set = new HashSet<>();

        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }

        int middle = sum / 2;

        for(int i=0;i<nums.length; i++){
            int cur = nums[i];

            Set<Integer> newSet = new HashSet<>(set);

            set.forEach(num -> newSet.add(num + cur));
            newSet.add(cur);

            set = newSet;

        }


        return set.contains(middle);
    }
}
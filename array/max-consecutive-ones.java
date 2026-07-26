class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = count;
        for(int i = 0; i<n; i++){
            if(nums[i] !=1){
               count =0;
            } else{
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
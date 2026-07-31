class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int sec = 0;
        int max = Integer.MIN_VALUE;
        for(int k =0;k<n;k++){
            if(nums[k]> max ){
                sec = max;
                max = nums[k];
            } else if(nums[k]<=max && nums[k] > sec){
                sec = nums[k];
            }
        }
        int res = (max -1)*(sec-1);
        return res;
    }
}
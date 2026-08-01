class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int sec = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        if(n==2){
            return ((nums[0]-1) *(nums[1]-1));
        }
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
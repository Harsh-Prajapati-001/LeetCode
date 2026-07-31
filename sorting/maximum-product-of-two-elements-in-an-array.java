class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        for(int i = n-1; i>n-3;i--){
            for(int j =0;j<n-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        int res = (nums[n-1]-1)*(nums[n-2]-1);
        return res;
    }
}
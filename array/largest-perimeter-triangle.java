class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        int i =1;
        int maxi = 0;
        if(n<3){
            return 0;
        }
        Arrays.sort(nums);
        while( i<n-1){
            if(nums[i-1] >= nums[i] + nums[i+1]){
             i++;
            } else if(nums[i] >= nums[i-1] +nums[i+1]){
                i++;
            } else if(nums[i+1] >= nums[i] +nums[i-1]){
                i++;
            }else{
                maxi = Math.max(maxi ,  nums[i] + nums[i-1] +nums[i+1]);
                i++;
            }
        }
        return maxi;
    }
}
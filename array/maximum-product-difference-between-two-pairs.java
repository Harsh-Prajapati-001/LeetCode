class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length; 
        int maxi =0;
        if(n<4){
            return maxi;
        }
        Arrays.sort(nums);
    
        maxi = (nums[n-1]*nums[n-2])-(nums[0]*nums[1]);
       return maxi;
    }
}
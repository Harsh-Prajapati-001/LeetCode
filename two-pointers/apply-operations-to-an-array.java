class Solution {
    public int[] applyOperations(int[] nums) {
       int n = nums.length;
       for(int i=0;i<n;i++){
        if(i<n-1 && nums[i] == nums[i+1]){
            nums[i]= 2*nums[i];
            nums[i+1] = 0;
        }
       } 
       int k =-1;
       for(int  j = 0; j<n; j++){
          if(nums[j]==0){
            k =j;
            break;
          }
       }
       for(int j =k+1; j<n;j++){
        if(nums[j]!= 0){
            nums[k] =nums[j];
            nums[j] = 0;
            j++;
        }
       }
       return nums;
    }
}
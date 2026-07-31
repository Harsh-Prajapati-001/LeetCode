class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<=n-2; i++){
            int mini = i;
            for(int j = i; j<n; j++){
                if(nums[j] <nums[mini]){
                    mini =j;
                }
            }
            int temp = nums[mini];
            nums[mini] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
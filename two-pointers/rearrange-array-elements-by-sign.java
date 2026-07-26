class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n] ;
        int eve = 0;
        int odd = 1;
        for( int i = 0; i< n;i++){
            if(nums[i] >= 0){
                res[eve] = nums[i];
                eve += 2;

            }else{
                res[ odd] = nums[i] ;
                odd +=2;
                }
        }
    return res;
    }
}    

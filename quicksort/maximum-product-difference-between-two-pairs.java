class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length; 
        int u1 =0; int u2 = 0;
        int l1 = Integer.MAX_VALUE;
        int l2 = Integer.MAX_VALUE;
        int maxi =0;
        for(int x:nums){
            if(x<l2){
                if(x<l1){ 
                    l2 = l1;
                    l1 = x;
                }
                else{
                    l2 =x;
                }
            }
            if(x>u2){
                if(x>u1){
                    u2=u1;
                    u1 = x;
                }
                else{
                    u2 = x;
                }
            }
        }
    
        maxi = (u1*u2)-l1*l2;
       return maxi;
    }
}
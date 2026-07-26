import java.util.*;
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        int j =0;
        int k = n-1;
        int last = n-1;
        while(j<=k){
            if((nums[j]*nums[j]) > (nums[k]*nums[k])){
                res[last] = nums[j]*nums[j];
                j++; last--;
            } else if((nums[j]*nums[j]) <= (nums[k]*nums[k])){
                res[last] = nums[k]*nums[k];
                k--; last--;
            }
        }
        return res;
    }
}
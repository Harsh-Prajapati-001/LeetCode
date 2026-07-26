class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxarea= Integer.MIN_VALUE;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            maxarea = Math.max(maxarea, area);
            if(height[left]< height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;
    }
}
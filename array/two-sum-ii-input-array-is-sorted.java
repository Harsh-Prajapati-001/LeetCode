class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int [] res = new int[2];
        int k = n -1;
        int j = 0;
        while(j<k){ 
            int sum = numbers[j] + numbers[k];
            if(sum < target){
                j++;
            }else if(sum == target){
                res[0] = j+1;
                res[1] = k+1;
                break;
            }
            else{ k--;}
            
        }
        return res;
    }
}
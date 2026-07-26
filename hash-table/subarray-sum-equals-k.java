class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int presum = 0; 
        int count = 0;
        HashMap <Integer, Integer> freq = new HashMap <>();
        freq.put(0,1);
        for(int i =0; i< n; i++){
            presum +=nums[i];
            int diff = presum - k;
            if(freq.containsKey(diff)){
                count += freq.get(diff);
            }
            freq.put(presum, freq.getOrDefault(presum,0)+1);
        }
        return count;

    }
}
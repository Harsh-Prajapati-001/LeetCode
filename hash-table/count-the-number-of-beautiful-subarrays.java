class Solution {
    public long beautifulSubarrays(int[] nums) {
        long count = 0;
        int xor =0;
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        for(int i =0; i<n;i++){
            xor ^= nums[i];
            if(freq.containsKey(xor^0)){
                count += freq.get(xor^0);
            }
            if(freq.containsKey(xor)){
                freq.put(xor, freq.get(xor)+1);
            }else{
                freq.put(xor,1);
            }
        }
        return count;
    }
}
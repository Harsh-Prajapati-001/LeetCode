class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int max = 0;
        Arrays.sort(citations);

        for(int i =0; i<n;i++){
            int x = citations[i];
            if(citations[i] <= n-i){
                max = Math.max (max,citations[i]);
            }  
        }
        
        return max;
    }
}
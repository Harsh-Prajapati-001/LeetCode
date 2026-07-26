class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int tol = n * n;
        int[] freq = new int[tol + 1];
        for(int i =0; i<n;i++){
           for(int j = 0;j<n;j++){
              freq[grid[i][j]]++;
           }
        }
        int rep = -1;
        int miss = -1;
        for(int m = 1; m <=tol;m++){
            if(freq[m]==2){
                rep =m;
            }
            else if(freq[m] ==0){
                miss =m;
            }
        }
        return new int[]{rep, miss};
    }
}
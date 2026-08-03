class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int res =0;
        
        for(int i=0; i<n;i++){
            int k =0;
            while(k<s.length){
                if(s[k] == g[i]){
                    s[k] =-1;
                    k++; res++;
                }
                k++;
            }
        }
    return res;
    }
}
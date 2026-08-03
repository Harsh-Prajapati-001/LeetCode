class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int res =0;
        
        for(int i=0; i<n;i++){
            int k =0;
            while(k<s.length && res<n){
                if(s[k] == g[i]){
                    s[k] =-1;
                    k++; res++;
                }
                else{k++; }
            }
        }
    return res;
    }
}
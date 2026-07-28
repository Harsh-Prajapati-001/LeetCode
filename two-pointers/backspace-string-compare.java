class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i =s.length() -1;
        int k =t.length()-1;
        while(i >= 0 || k >=0){
            int skips =0;
            while(i>=0){
                if(s.charAt(i) =='#'){
                    skips++;
                    i--;
                } else if(skips >0){
                    skips--;
                    i--;
                }else{
                    break;
                }
            }
                int skipt =0;
            while(k>=0){
                if(t.charAt(k) =='#'){
                    skipt++;
                    k--;
                } else if(skipt >0){
                    skipt--;
                    k--;
                }else{
                    break;
                }
            }
            if(i>=0 && k>=0){
                if(s.charAt(i) != t.charAt(k)){
                    return false;
                }
            } else if(i >=0 || k >=0){
                    return false;
                }
            i--;
            k--;

        }
    return true;
    }
}
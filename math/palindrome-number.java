class Solution {
    public boolean isPalindrome(int x) {
        int l ;
        int res = 0;
        int dup = x;
        while(x >0){
            l = x% 10;
            x = x/10;
            res = res *10 + l;
        }if(res == dup){
            return true;
        }else return false;
    }
}
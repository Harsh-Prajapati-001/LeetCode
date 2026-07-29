class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        int i =0;
        int j =0;
        while(j<m && i<n){
            if(name.charAt(i) == typed.charAt(j)){
                i++;j++;
            }else if(name.charAt(i) != typed.charAt(j)){
                j++;
            }

        }
        return i==n;
    }
}
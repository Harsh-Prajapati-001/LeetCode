class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List res = new ArrayList <>();
        int hors =0;
        int horr = matrix.length-1;
        int veru =0;
        int verd = matrix[0].length-1;
        while(hors <= horr && veru <= verd){
            for(int i = veru; i<= verd; i++){
                res.add(matrix[hors][i]);
            }
            hors++;
            for(int i = hors; i<= horr; i++){
                res.add(matrix[i][verd]);
            }
            verd--;
            if(hors <= horr){
                for(int i = verd; i>= veru; i--){
                    res.add(matrix[horr][i]);
                }
                horr--;
            }
            if(veru <= verd){
                for(int i = horr; i>= hors; i--){
                    res.add(matrix[i][veru]);
                }
                veru++;
            }
        }
        return res;
    }
}
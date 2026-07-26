class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int row =0; row<numRows; row++){
            long ans=1;
            List<Integer> rows =new ArrayList<>();
            rows.add(1);
            for(int col =1; col<=row; col++){
                ans = ans*(row-col+1);
                ans = ans/col;
                rows.add((int)ans);
            }
            pascal.add(rows);
        }
        return pascal;
    }
}
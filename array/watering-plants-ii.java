class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int a = capacityA; int b = capacityB;
        int refill= 0;
        int n =plants.length;
        int i =0; int j = n-1;
        while(i<=j){
            if(i==j && Math.max(a,b) >= plants[i]){
                break;
            }else if(i == j && Math.max(a,b) < plants[i]){
                refill++;
            } 
            while(i<j && a>=plants[i]){
               i++;
               a = a-plants[i];
            } if(i<j && a<plants[i]){
                refill++;
                a = capacityA;
            }
            while(i<j && b>= plants[j]){
                j--;
                b = b-plants[j];
            } if(i<j && b<plants[j]){
                refill++;
                b = capacityB;
            }
            
        }
        return refill;
    }
}
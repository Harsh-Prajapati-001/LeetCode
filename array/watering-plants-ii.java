class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int a = capacityA; int b = capacityB;
        int refill= 0;
        int n =plants.length;
        int i =0; int j = n-1;
        while(i<j){
            if(a<plants[i]){
                refill++;
                a = capacityA;
            } a = a-plants[i];
            i++;
            if(b<plants[j]){
                refill++;
                b= capacityB;
            } b= b- plants[j];
            j--;

            
        }
        if(i ==j){
            if(Math.max(a,b) < plants[i]){
                refill++;
            }    
        }
        return refill;
    }
}
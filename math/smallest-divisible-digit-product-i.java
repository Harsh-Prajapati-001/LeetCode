class Solution {
    public int smallestNumber(int n, int t) {

        for (int num = n; ; num++) {
            int product = digitProduct(num);

            if (product % t == 0) {
                return num;
            }
        }
    }

    private int digitProduct(int num) {
        int product = 1;

        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }

        return product;
    }
}
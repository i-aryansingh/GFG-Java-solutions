class Solution {
    public long get_Sum(int n, int[] input) {
        // code here
       long sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        return sum;
    }
}
class Solution {
    public int minOperations(int[] arr) {
        // code here
         PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (int num : arr) {
            sum += num;
            maxHeap.offer((double) num);
        }
        double target = sum / 2.0;
        int operations = 0;
        while (sum > target) {
            double largest = maxHeap.poll();
            double half = largest / 2.0;
            sum -= (largest - half);
            maxHeap.offer(half);
            operations++;
        }
        return operations;
    }
}
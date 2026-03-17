class Solution {
    public int minMen(int arr[]) {
        // code here
          int n = arr.length;
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{left, right});
            }
        }
        intervals.sort((a, b) -> a[0] - b[0]);
        int count = 0;
        int i = 0;
        int currentEnd = 0;
        int farthest = 0;
        while (currentEnd <= n - 1) {
            boolean found = false;
            while (i < intervals.size() && intervals.get(i)[0] <= currentEnd) {
                farthest = Math.max(farthest, intervals.get(i)[1]);
                i++;
                found = true;
            }
            if (!found) return -1;  // No interval to extend coverage
            count++;
            currentEnd = farthest + 1;
            if (farthest >= n - 1)
                return count;
        }
        return -1;
    }
}